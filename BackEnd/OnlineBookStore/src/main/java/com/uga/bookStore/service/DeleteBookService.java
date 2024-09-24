package com.uga.bookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.uga.bookStore.model.Books;
import com.uga.bookStore.repo.BookRepo;
import com.uga.bookStore.response.GenericResponse_bookStore;

@Service
public class DeleteBookService {

	@Autowired
	BookRepo bookRepo;
	@Autowired
	GenericResponse_bookStore<Books> genericResponse;

	public GenericResponse_bookStore<Books> deleteBook(int bookId) {
		// Find the book by ID
		Books book = bookRepo.findById(bookId).orElse(null);

		if (book == null) {
			// Book not found
			genericResponse.setStatus("error");
			genericResponse.setResponseCode(HttpStatus.NOT_FOUND.toString());
			genericResponse.setDescription("Book not found");
		} 
		else {
			// Delete the book
			//bookRepo.delete(book);
			
			
			// Archive the book
            book.setArchived(true);
            bookRepo.save(book);
			genericResponse.setStatus("success");
			genericResponse.setResponseCode(HttpStatus.OK.toString());
			genericResponse.setDescription("Deleted Book");
		}

		return genericResponse;
	}
}



