package com.bookstorelite.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstorelite.backend.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}
