package com.uga.bookStore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uga.bookStore.model.BooksFeaturedTopsellers;

public interface BooksFeaturedTopsellersRepo extends JpaRepository<BooksFeaturedTopsellers, Integer> {

    @Query("SELECT b FROM BooksFeaturedTopsellers b WHERE b.featured = true")
    List<BooksFeaturedTopsellers> findByFeatured();

    List<BooksFeaturedTopsellers> findByTopseller(boolean topseller);

    List<BooksFeaturedTopsellers> findByNewBook(boolean newBook);
}
