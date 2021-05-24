package com.bookstore.springtest.dao;

import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Buy;
import com.bookstore.springtest.entity.BuyBook;

import java.util.Date;
import java.util.List;

public interface BuyDao {
    String update(Buy buy);
    List<Buy> findAll(Integer customer_id);
    List<Buy> findAll();
    List<Buy> findTime(Date date);
    List<Buy> findByIdTime(Integer id,Date date);
    String updateAll(BuyBook buyBook);
}
