package com.uga.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uga.bookStore.Exceptions.AccountAlreadyExistsException;
import com.uga.bookStore.Exceptions.EditProfileException;
import com.uga.bookStore.Exceptions.InvalidOTPException;
import com.uga.bookStore.Exceptions.PaymentCardLimitException;
import com.uga.bookStore.constants.AppConstants;
import com.uga.bookStore.model.AccountStatusEnum;
import com.uga.bookStore.model.AccountTypeEnum;
import com.uga.bookStore.model.Login;
import com.uga.bookStore.model.LoginRequest;
import com.uga.bookStore.model.PaymentCard;
import com.uga.bookStore.model.Response;
import com.uga.bookStore.model.ShippingAddress;
import com.uga.bookStore.model.User;
import com.uga.bookStore.model.UserTypeEnum;
import com.uga.bookStore.repo.PaymentRepo;
import com.uga.bookStore.repo.ShippingAddressRepo;
import com.uga.bookStore.repo.UserRepo;
import com.uga.bookStore.security.JwtUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

@Service

public class UserService implements UserServiceImpl {
	private final UserRepo userRepo;
	@Autowired
	private EmailService emailService;

	@Autowired
	private final PaymentRepo paymentRepo;
	@Autowired
	private final ShippingAddressRepo shippingAddressRepo;
	
    private Set<String> invalidatedTokens = new HashSet<>();


	@Autowired
	 public UserService(UserRepo userRepo, PaymentRepo paymentRepo, ShippingAddressRepo shippingAddressRepo) {
		this.userRepo = userRepo;
		this.paymentRepo = paymentRepo;
		this.shippingAddressRepo = shippingAddressRepo;
	}

	@Autowired
	JwtUtils jwtUtils;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepo.findByUserId(id);
	}

	@Override
	public User updateUser(Long id, User user, HttpServletRequest request) {
		Optional<User> existingUser = userRepo.findByUserId(id);
		String token = request.getHeader("Authorization").replace("Bearer ", "");
		User userDetail = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).get();
		
		
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setEmail(user.getEmail());
			return userRepo.save(updatedUser);
		}
		return null; // Or throw an exception if user with given id is not found
	}

	@Override
	public Response registerUser(User userRegister, HttpServletRequest request, Map<String, Object> model) throws PaymentCardLimitException, AccountAlreadyExistsException  {
		Response response = new Response();
		Optional<User> accountData = userRepo.findByEmail(userRegister.getEmail());
		if (accountData.isEmpty()) {
			int min = 10000;
			int max = 99999;
			int OtpCode = (int) (Math.random() * (max - min + 1) + max);
			userRegister.setOtpCode(OtpCode);
			userRegister.setAccountStatusId(AccountStatusEnum.INACTIVE.getType());
			userRegister.setAccountType(UserTypeEnum.CUSTOMER);
			List<PaymentCard> paymentCards = userRegister.getPaymentCard();
			List<ShippingAddress> shippingAddress = userRegister.getShippingAddress();
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encryptedPassword = encoder.encode(userRegister.getPassword());
			userRegister.setPassword(encryptedPassword);
			String url = getSiteURL(request);
			String verifyURL = "http://localhost:4200/";
			model.put("name", userRegister.getFirstName() + "  " + userRegister.getLastName());
			model.put("URL", verifyURL);
			model.put("verificationCode", userRegister.getOtpCode());
			if (paymentCards.size() > 3) {
				response.setMessage("Users can have only 3 Payment Cards. Please delete a card to add a new card");	
				response.setStatus(Boolean.FALSE);
				return response; 
				} else {
				response = emailService.sendEmailVerification(userRegister.getEmail(), "Online BookStore email address confirmation instructions",
						model);
			
				if (response.getStatus() == Boolean.TRUE) {
					response.setOtp(userRegister.getOtpCode());

					userRepo.save(userRegister);			
//					  if (userRegister.getPaymentCards() != null && !userRegister.getPaymentCards().isEmpty()) {
//					  paymentRepo.deletePaymentCard(userRegister.getUserId());
//						  paymentRepo.resetPaymentAutoIncrement();
//				        }
//				        
//				        if (userRegister.getShippingAddress() != null && !userRegister.getShippingAddress().isEmpty()) {
//				            shippingAddressRepo.deletShippingAddress(userRegister.getUserId());
//				            shippingAddressRepo.resetShippingAutoIncrement();	            
//		            
//				        }
				}
			}
		} else {
			response.setMessage("User email already exists in the system");
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}



	@Override
	public ResponseEntity<?> signin(LoginRequest loginRequest) {
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

		return user;
	}

	private String getSiteURL(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		return url.replace(request.getServletPath(), "");
	}

	@Override
	public Response forgotPassword(User user, HttpServletRequest request, Map<String, Object> model) {
		Response response = new Response();
		Optional<User> userObject = userRepo.findByEmail(user.getEmail());
		int min = 10000;
		int max = 99999;
		int OtpCode = (int) (Math.random() * (max - min + 1) + max);
		userObject.get().setOtpCode(OtpCode);
		String url = getSiteURL(request);
		String verifyURL = "http://localhost:4200/create-new-password";
		model.put("name", userObject.get().getFirstName() + " " + userObject.get().getLastName());
		model.put("URL", verifyURL);
		model.put("OTP", OtpCode);
		response = emailService.sendEmailOTP(userObject.get().getEmail(),
				"Password Reset: Email Confirmation Instructions", model);
		response.setOtp(OtpCode);
		if (response.getStatus() == Boolean.TRUE) {
			userRepo.save(userObject.get());
		}
		return response;
	}

	@Override
	public Response verifyForgotPasswordOTP(User user, HttpServletRequest request) throws InvalidOTPException {
		Optional<User> userObject = userRepo.findByEmail(user.getEmail());
		Response response = new Response();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (userObject != null) {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepo.updatePasswordByEmail(user.getEmail(),user.getPassword());
			response.setMessage("Password reset sucessful");
			response.setStatus(Boolean.TRUE);
		} else {
			throw new InvalidOTPException("OTP is invalid");
		}
		return response;
	}


	@Override
	public ResponseEntity<?> deletePaymentCards(PaymentCard paymentCard) {
		paymentRepo.deleteByCardNumber(paymentCard.getCardNumber());
		return new ResponseEntity<>("Card deleted successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> addPaymentCard(List<PaymentCard> paymentCards, HttpServletRequest request)
			throws PaymentCardLimitException {
		String token = request.getHeader("Authorization").replace("Bearer ", "");
		User user = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).get();
		List<PaymentCard> existingCards = paymentRepo.findAllByUser(user);
		if (existingCards.size() == 3) {
			throw new PaymentCardLimitException(
					"There are already three Payments cards in the system. To add a new card, delete an existing card");
		} else if (paymentCards.size() + existingCards.size() > 3) {
			throw new PaymentCardLimitException(
					"There are already three Payments cards in the system. To add a new card, delete an existing card");
		} else {
			paymentCards.forEach(card -> {
				card.setUser(user);
				paymentRepo.save(card);
			});
		}
		return new ResponseEntity<>("Card added successfully", HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> editPaymentCard(PaymentCard updatedPaymentCard, HttpServletRequest request) {
	    String token = request.getHeader("Authorization").replace("Bearer ", "");
	    User user = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).orElse(null);

	    if (user == null) {
	        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	    }

	    PaymentCard existingCard = paymentRepo.findByPaymentId(updatedPaymentCard.getPaymentId());

	    if (existingCard == null) {
	        return new ResponseEntity<>("Payment card not found", HttpStatus.NOT_FOUND);
	    }

	    existingCard.setCardType(updatedPaymentCard.getCardType());
	    existingCard.setCardHolder(updatedPaymentCard.getCardHolder());
	    existingCard.setCardNumber(updatedPaymentCard.getCardNumber());
	    existingCard.setExpDate(updatedPaymentCard.getExpDate());
	    paymentRepo.save(existingCard);

	    return new ResponseEntity<>("Payment card updated successfully", HttpStatus.OK);
	}
	
	@Override
	public Response editProfile(User user, HttpServletRequest request, Map<String, Object> model)
			throws EditProfileException {
		Response response = new Response();
		try {
			String token = request.getHeader("Authorization").replace("Bearer ", "");
			Optional<User> oldUser = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token));
			User oldUserToUpdate = oldUser.get();
			entityManager.detach(oldUserToUpdate);
			oldUserToUpdate.setFirstName(user.getFirstName());
			oldUserToUpdate.setLastName(user.getLastName());
			if(user.getPassword()!=null) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String encryptedPassword = encoder.encode(user.getPassword());
				oldUserToUpdate.setPassword(encryptedPassword);		
			}
			oldUserToUpdate.setMobileNumber(user.getMobileNumber());
			oldUserToUpdate.setSubscribeToPromo(user.isSubscribeToPromo());
			
			userRepo.save(oldUserToUpdate);
			response.setMessage("Updated profile");
			response.setStatus(Boolean.TRUE);
			emailService.sendEmailNotification(oldUserToUpdate.getEmail(), AppConstants.UPDATE_PROFILE_EMAIL_SUBJECT,
					AppConstants.UPDATE_PROFILE_EMAIL_BODY);
		} catch (Exception e) {
			throw new EditProfileException("Error updating the profile");
		}
		return response;
	}
	

	@Override
	public ResponseEntity<?> addShippingAddress(List<ShippingAddress> shippingAddress, HttpServletRequest request)
		 {
		String token = request.getHeader("Authorization").replace("Bearer ", "");
		User user = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).get();
		List<PaymentCard> existingCards = paymentRepo.findAllByUser(user);
	
		shippingAddress.forEach(address -> {
			address.setUser(user);
			shippingAddressRepo.save(address);
		});
		return new ResponseEntity<>("Address added successfully", HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<?> editShippingAddress(ShippingAddress updatedShippingAddress, HttpServletRequest request) {
	    String token = request.getHeader("Authorization").replace("Bearer ", "");
	    User user = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).orElse(null);

	    if (user == null) {
	        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	    }

	    ShippingAddress existingAddress = shippingAddressRepo.findByAddressId(updatedShippingAddress.getAddressId());

	    if (existingAddress == null) {
	        return new ResponseEntity<>("Shipping address not found", HttpStatus.NOT_FOUND);
	    }

	    existingAddress.setStreet(updatedShippingAddress.getStreet());
	    existingAddress.setCity(updatedShippingAddress.getCity());
	    existingAddress.setState(updatedShippingAddress.getState());
	    existingAddress.setZipCode(updatedShippingAddress.getZipCode());
	    shippingAddressRepo.save(existingAddress);

	    return new ResponseEntity<>("Shipping address updated successfully", HttpStatus.OK);
	}

	@Override
	public List<PaymentCard> getPaymentCards(HttpServletRequest request) {
		String token = request.getHeader("Authorization").replace("Bearer ", "");
		User user = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).get();
		List<PaymentCard> cards = paymentRepo.findAllByUser(user);
		return cards;
	}
	
	@Override
	public List<ShippingAddress> getShippingAddresses(HttpServletRequest request) {
		String token = request.getHeader("Authorization").replace("Bearer ", "");
		User user = userRepo.findByEmail(jwtUtils.getUserNameFromJwtToken(token)).get();
		List<ShippingAddress> addresses = shippingAddressRepo.findAllByUser(user);
		return addresses;
	}
	
	@Override
	public Response verifyUser(User user) {
		Response response = new Response();
		User userObject = userRepo.findByOtpCode(user.getOtpCode());
		if (userObject == null || userObject.getAccountStatusId()== 2) {
			response.setMessage("User email is not present in system or user account is already active");
		} else {
			userObject.setAccountStatusId(2);
			userRepo.save(userObject);
			response.setMessage("Successfully Verified");
			response.setStatus(Boolean.TRUE);
		}
		return response;
	}

	

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteByUserId(id);
	}

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
