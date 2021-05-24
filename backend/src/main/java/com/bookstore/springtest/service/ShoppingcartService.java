package com.bookstore.springtest.service;

import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Shoppingcart;

import java.util.List;

public interface ShoppingcartService {
    String update(Shoppingcart shoppingcart);
    List<Book> findAll(Integer customer_id);
    List<Shoppingcart> findAll();
    void deleteOne(Integer cusid,Integer bookid);
    void deleteAll(Integer id);
}
