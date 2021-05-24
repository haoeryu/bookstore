package com.bookstore.springtest.controller;


import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Shoppingcart;
import com.bookstore.springtest.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@Scope("session")
@RequestMapping("/shopping")
public class ShoppingcartHandler {
    @Autowired
    private ShoppingcartService shoppingcartService;
    @Autowired
    WebApplicationContext applicationContext;

    @PutMapping("/update")
    public String update(@RequestBody Shoppingcart shoppingcart){return shoppingcartService.update(shoppingcart);}

    @GetMapping("/findAll/{customer_id}")
    public List<Book> findAll(@PathVariable("customer_id") Integer customer_id){
        shoppingcartService = applicationContext.getBean(ShoppingcartService.class);
        System.out.println(shoppingcartService);
        System.out.println(this);

        return shoppingcartService.findAll(customer_id);}

    @GetMapping("/findAll")
    public List<Shoppingcart> findAll(){
        shoppingcartService = applicationContext.getBean(ShoppingcartService.class);
        System.out.println(shoppingcartService);
        System.out.println(this);
        return shoppingcartService.findAll();
    }

    @DeleteMapping("/deleteOne/{customerid}/{bookid}")
    public void deleteOne(@PathVariable("customerid") Integer cusid,@PathVariable("bookid") Integer bookid){shoppingcartService.deleteOne(cusid,bookid);}

    @DeleteMapping("/deleteAll/{customer_id}")
    public void deleteAll(@PathVariable("customer_id") Integer id){shoppingcartService.deleteAll(id);}
}
