package com.bookstore.springtest.controller;


import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Buy;
import com.bookstore.springtest.entity.BuyBook;
import com.bookstore.springtest.service.BuyService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buy")
public class BuyHandler {
    @Autowired
    private BuyService buyService;

    @PutMapping("/update")
    public String update(@RequestBody Buy buy){return buyService.update(buy);}

    @PutMapping("/updateAll")
    public String updateAll(@RequestBody BuyBook buyBook){return buyService.updateAll(buyBook);}

    @GetMapping("/findAll")
    public List<Buy> findAll() {
        return buyService.findAll();
    }

    @GetMapping("/findAll/{customer_id}")
    public List<Buy> findAll(@PathVariable("customer_id") Integer customer_id){
        return buyService.findAll(customer_id);
    }

    @GetMapping("/findAllByDate/{id}/{date}")
    public List<Buy> findByIdTime(@PathVariable("id") Integer id, @PathVariable("date") Date date){
        return buyService.findByIdTime(id,date);
    }

    @GetMapping("/findTime/{date}")
    public List<Buy> findTime(@PathVariable("date") Date date){
        return buyService.findTime(date);
    }

}
