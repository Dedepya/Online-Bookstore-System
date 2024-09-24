package com.uga.bookStore.service;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.uga.bookStore.model.Books;
import com.uga.bookStore.model.BooksFeaturedTopsellers;
import com.uga.bookStore.model.BooksReq;
import com.uga.bookStore.repo.BookRepo;
import com.uga.bookStore.repo.BooksFeaturedTopsellersRepo;
import com.uga.bookStore.response.GenericResponse_bookStore;

@Service
public class AddBookService {
	
	@Autowired
	BookRepo bookRepo;
	@Autowired
	BooksFeaturedTopsellersRepo books_featured_topsellers_Repo;
	@Autowired
	GenericResponse_bookStore<Books> genericResponse;
	
	
	
	public GenericResponse_bookStore<Books> addBook(BooksReq books) {
		// TODO Auto-generated method stub
		Books add_book = new Books();
		add_book.setISBN(books.getISBN());
		add_book.setTitle(books.getTitle());
		add_book.setAuthor(books.getAuthor());
		add_book.setCategory(books.getCategory());
		add_book.setPublisher(books.getPublisher());
		add_book.setPublication_Year(books.getPublication_Year());
		add_book.setEdition(books.getEdition());
		add_book.setSelling_Price(books.getSelling_Price());
		add_book.setBuying_Price(books.getBuying_Price());
		add_book.setQuantity(books.getQuantity());
		add_book.setDescription(books.getDescription());
		String file = books.getImage_data();
        
  
        add_book.setImage_data(file);
        bookRepo.save(add_book);
        BooksFeaturedTopsellers isfilter= new BooksFeaturedTopsellers();
        isfilter.setFeatured(books.getIsFeatured());
        isfilter.setNewBook(books.getIsNewBook());
        isfilter.setTopseller(books.getIsTopseller());
        isfilter.setBookID(add_book.getBookID());
        books_featured_topsellers_Repo.save(isfilter);
        
        genericResponse.setDetails((Books) add_book);
        genericResponse.setStatus("success");
        genericResponse.setResponseCode(HttpStatus.CREATED.toString());
        genericResponse.setDescription("Created Book");
		return genericResponse;
	}
}
