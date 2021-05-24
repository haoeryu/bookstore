package com.bookstore.springtest.service;

import com.bookstore.springtest.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CustomerService {
    String update(Customer customer);
    List<Customer> findAll();
    String save(Customer customer);
    String loginCheck(Customer customer, HttpSession session);
    Customer findCustomerById(Integer id);
    Page<Customer> findAll(Pageable pageable);
    String ban(String username);
    String unban(String username);
//    Customer loginCheck();
}
