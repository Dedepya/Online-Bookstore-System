package com.uga.bookStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "books_featured_topsellers")
public class BooksFeaturedTopsellers {
    
    @Id
    @Column(name = "BookID")
    private int bookID;
    
    @Column(name = "featured")
    private boolean featured;
    
    @Column(name = "topseller")
    private boolean topseller;
    
    @Column(name = "newbook")
    private boolean newBook;

    // Constructors, getters, and setters
}
