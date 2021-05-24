package com.bookstore.springtest.dao;

import com.bookstore.springtest.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CustomerDao {
    String update(Customer customer);
    String save(Customer customer);
    List<Customer> findAll();
    String loginCheck(Customer customer, HttpSession session);
    Customer findOne(Integer id);
    Page<Customer> findAll(Pageable pageable);
    String ban(String username);
    String unban(String username);
//    Customer loginCheck();
}
