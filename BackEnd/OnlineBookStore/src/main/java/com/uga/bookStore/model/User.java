package com.uga.bookStore.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false,name="User_Id")
	private Integer userId;

	@NotBlank(message = "First Name should not be empty")
	private String firstName;

	@NotBlank(message = "First Name should not be empty")
	private String lastName;

	@Email(message = "Email is not valid", regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
			+ "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
	@NotNull(message = "Email should not be empty")
	private String email;

	@NotNull(message = "Password required")
	@Column
	private String password;

	@NotNull(message = "Mobile number required")
	@Size(max = 10, min = 10, message = "Phone number should contain 10 digits")
	private String mobileNumber;

	
	@Column(name = "subscribe_to_promo", columnDefinition = "boolean default false")
	private boolean subscribeToPromo;

	@JsonIgnore
	private int accountStatusId;
	private int otpCode;

	public User() {
		// Default constructor
	}

	public User(@NotBlank(message = "First Name should not be empty") String firstName,
			@NotBlank(message = "Last Name should not be empty") String lastName,
			@Email(message = "Email is not valid") @NotNull(message = "Email should not be empty") String email,
			@NotNull(message = "Password required") String password,

			@NotNull(message = "Mobile number required") String mobileNumber,int otpCode,

			boolean subscribeToPromo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.otpCode = otpCode;
		this.subscribeToPromo = subscribeToPromo;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "Account_Type_ID")
	private UserTypeEnum accountType;

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<Authority> authList = new ArrayList<>();
//		authList.add(new Authority(userType.getName()));
		return Arrays.asList(new Authority(accountType.type));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	

	
	@OneToMany(targetEntity = PaymentCard.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	@Valid
	@JsonManagedReference
	public List<PaymentCard> paymentCards;
	@JsonManagedReference
	public List<PaymentCard> getPaymentCard() {
		return paymentCards;
	}

	public void setPaymentCard(List<PaymentCard> paymentCards) {
		this.paymentCards = paymentCards;
	}
	
	@OneToMany(targetEntity = ShippingAddress.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	@Valid    
	@JsonManagedReference
	public List<ShippingAddress> shippingAddresses;

	@JsonManagedReference
	public List<ShippingAddress> getShippingAddress() {
		return shippingAddresses;
	}

	public void setShippingAddress(List<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String extractTokenFromAuthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		return null;
	}

	public void invalidateToken(String token) {
		// TODO Auto-generated method stub
		
	}





}
