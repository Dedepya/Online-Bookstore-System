package com.uga.bookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.bookStore.model.Books;
import com.uga.bookStore.model.User;

public interface BookRepo extends JpaRepository<Books, Integer>{

}
