package com.uga.bookStore.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

import com.uga.bookStore.Exceptions.AccountAlreadyExistsException;
import com.uga.bookStore.Exceptions.EditProfileException;
import com.uga.bookStore.Exceptions.InvalidOTPException;
import com.uga.bookStore.Exceptions.PaymentCardLimitException;
import com.uga.bookStore.model.LoginRequest;
import com.uga.bookStore.model.PaymentCard;
import com.uga.bookStore.model.Response;
import com.uga.bookStore.model.ShippingAddress;
import com.uga.bookStore.model.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserServiceImpl extends UserDetailsService{

	List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	Response registerUser(User userRegister, HttpServletRequest request, Map<String, Object> model) throws PaymentCardLimitException, AccountAlreadyExistsException;

	Response forgotPassword(User user, HttpServletRequest request, Map<String, Object> model);

	Response verifyForgotPasswordOTP(User user, HttpServletRequest request) throws InvalidOTPException;

	User updateUser(Long id, User user, HttpServletRequest request);

	void deleteUser(Long id);
	
	ResponseEntity<?> signin(@Validated LoginRequest loginRequest);

	ResponseEntity<?> deletePaymentCards(PaymentCard paymentCard);

	ResponseEntity<?> addPaymentCard(List<PaymentCard> paymentCards, HttpServletRequest request) throws PaymentCardLimitException;

	List<PaymentCard> getPaymentCards(HttpServletRequest request);
	
	ResponseEntity<?> addShippingAddress(List<ShippingAddress> ShippingAddress, HttpServletRequest request) throws PaymentCardLimitException;
	
	ResponseEntity<?> editPaymentCard(PaymentCard updatedPaymentCard, HttpServletRequest request);
	
	List<ShippingAddress> getShippingAddresses(HttpServletRequest request);
	
	ResponseEntity<?> editShippingAddress(ShippingAddress updatedShippingAddress, HttpServletRequest request);

	Response editProfile(User user, HttpServletRequest request, Map<String, Object> model) throws EditProfileException;
	
	Response verifyUser(User user);

}
