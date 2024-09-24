package com.uga.bookStore.model;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class FilterBooksReq {
	private String bookName;
	private boolean category_motivation;
	private boolean category_drama;
	private boolean category_suspense;
	private boolean category_fantasy;
	private double price;
	private String author;
	private String publisher;
}
