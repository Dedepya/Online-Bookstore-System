package com.uga.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uga.bookStore.model.Books;
import com.uga.bookStore.model.BooksReq;
import com.uga.bookStore.repo.BookRepo;

import com.uga.bookStore.response.GenericResponse_bookStore;
import com.uga.bookStore.security.JwtUtils;
import com.uga.bookStore.service.AddBookService;
import com.uga.bookStore.service.DeleteBookService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private  AddBookService addBookService;
	@PostMapping("/addBook")
	public GenericResponse_bookStore<Books> addCourse(@RequestBody BooksReq booksReq) {
		GenericResponse_bookStore<Books> createdBook = addBookService.addBook(booksReq);
        return createdBook;
	}
	
	@Autowired
	private  DeleteBookService deleteBookService;
	@GetMapping("/deleteBook")
	public GenericResponse_bookStore<Books> deleteCourse(@RequestParam("data") int booksReq) {
		GenericResponse_bookStore<Books> deletedBook = deleteBookService.deleteBook(booksReq);
        return deletedBook;
		
	}
	
	//@GetMapping("/banUser")
	//public Response banUser(@RequestParam String userEmail) throws UserNotFoundException {
		//return adminService.banUser(userEmail);
	//}

	//@GetMapping("/unbanUser")
	//public Response unbanUser(@RequestParam String userEmail) throws UserNotFoundException {
		//return adminService.unbanUser(userEmail);
	//}
	
}
