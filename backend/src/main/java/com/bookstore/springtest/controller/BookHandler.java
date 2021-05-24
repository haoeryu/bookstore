package com.bookstore.springtest.controller;

import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.repository.BookRepository;
import com.bookstore.springtest.service.BookService;
import com.bookstore.springtest.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookService bookService;
    @Autowired
    WebApplicationContext applicationContext;

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/findLike/{booklike}")
    public List<Book> findLike(@PathVariable("booklike") String booklike) {
        return bookService.findLike(booklike);
    }

    @GetMapping("/findByName/{book}")
    public Book findByName(@PathVariable("book") String book) {
        return bookService.findByName(book);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookService.findAll(pageable);
    }

    @GetMapping("/findAll")
    public List<Book> findAll(){
        bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
        System.out.println(this);
        return bookService.findAll();
    }

    @PutMapping("/save")
    public String save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") Integer id){
        bookService.deleteById(id);
    }

    @DeleteMapping("/deleteByName/{name}")
    public  void deleteByName(@PathVariable("name") String name){
        bookService.deleteByName(name);
    }
}

