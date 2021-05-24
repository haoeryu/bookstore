package com.bookstore.springtest.dao;

import com.bookstore.springtest.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDao {
    Book findById(Integer id);
    Page<Book> findAll(Pageable pageable);
    String save(Book book);
    String update(Book book);
    void deleteById(Integer id);
    List<Book> findAll();
    List<Book> findLike(String booklike);
    Book findByName(String book);
    void deleteByName(String name);
}
