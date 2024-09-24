package com.uga.bookStore.model;

import lombok.Data;

@Data
public class GetBooksReq {
	private boolean featuredBooks;
	private boolean topBooks;
	private boolean newBooks;
}
