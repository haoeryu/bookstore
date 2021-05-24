package com.bookstore.springtest.dao;

import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Shoppingcart;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShoppingcartDao {
    String update(Shoppingcart shoppingcart);
    List<Book> findAll(Integer customer_id);
    List<Shoppingcart> findAll();
    void deleteOne(Integer cusid,Integer bookid);
    void deleteAll(Integer id);
}
