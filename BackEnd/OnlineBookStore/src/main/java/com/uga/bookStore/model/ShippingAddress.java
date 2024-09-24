package com.uga.bookStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipping_address")     
@Data
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private int addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    


	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "User_Id")
	private User user;


    public ShippingAddress() {
        // Default constructor
    }

    public ShippingAddress(String street, String city, String state, String zipCode) {
    	super();
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    @JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
