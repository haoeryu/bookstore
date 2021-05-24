package com.bookstore.springtest.service;

import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Buy;
import com.bookstore.springtest.entity.BuyBook;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface BuyService {
    String update(Buy buy);
    List<Buy> findAll(Integer customer_id);
    List<Buy> findAll();
    List<Buy> findTime(Date date);
    List<Buy> findByIdTime(Integer id,Date date);
    String updateAll(BuyBook buyBook);
}
