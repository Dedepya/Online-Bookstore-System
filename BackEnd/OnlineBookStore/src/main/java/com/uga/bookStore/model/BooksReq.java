package com.uga.bookStore.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter @Setter 
public class BooksReq {
	@Id
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
	 	private String image_data;
	 	private Boolean isFeatured;
	 	private Boolean isTopseller;
	 	private Boolean isNewBook;
}
