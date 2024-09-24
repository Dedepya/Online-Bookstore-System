package com.uga.bookStore.model;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="books")
@Data

public class Books {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable = false, updatable = false)
	    private int BookID;  // Updated field name from userId to id
	 	private String ISBN;
	 	private String Title;
	 	private String Author;
	 	private String Category;
	 	private String Publisher;
	 	private Date Publication_Year;
	 	private String Edition;
	 	private Double Buying_Price;
	 	private Double Selling_Price;
	 	private int Quantity;
	 	@Lob
	 	@Column(name = "description", columnDefinition="longtext")
	 	private String Description;
	 	@Column(name = "image_data", columnDefinition="longtext")
	 	private String image_data;
	 	
		public void setArchived(boolean b) {
			// TODO Auto-generated method stub
			
		}
}
