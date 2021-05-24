package com.bookstore.springtest.repository;


import com.bookstore.springtest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findByName(String name);
    public List<Book> findByNameContains(String booklike);
}
