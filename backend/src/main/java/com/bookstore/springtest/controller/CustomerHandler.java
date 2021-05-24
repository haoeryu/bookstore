package com.bookstore.springtest.controller;

import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Customer;
import com.bookstore.springtest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerHandler {
    @Autowired
    private CustomerService customerService;

    @PutMapping("/update")
    public String update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @PutMapping("/save")
    public String save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/ban/{username}")
    public String ban(@PathVariable("username") String username) {return customerService.ban(username);}

    @PutMapping("/unban/{username}")
    public String unban(@PathVariable("username") String username) {return customerService.unban(username);}

    @GetMapping("/findAll")
    public List<Customer> findAll(){return customerService.findAll();}

    @PutMapping("/loginCheck")
    public String loginCheck(@RequestBody Customer customer,HttpSession session) {
        return  customerService.loginCheck(customer,session);
    }

    @RequestMapping("/getUsername")
    public String getUsername(HttpSession session)
    {
        String username =(String) session.getAttribute("user");
        return username;
    }

    @GetMapping("/findCustomer/{id}")
    public Customer findCustomer(@PathVariable("id")Integer id,HttpSession session){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Customer> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return customerService.findAll(pageable);}
}
