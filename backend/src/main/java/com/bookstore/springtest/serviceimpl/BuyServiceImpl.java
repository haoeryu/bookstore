package com.bookstore.springtest.serviceimpl;


import com.bookstore.springtest.dao.BuyDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Buy;
import com.bookstore.springtest.entity.BuyBook;
import com.bookstore.springtest.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private BuyDao buyDao;

    @Override
    public String update(Buy buy){return buyDao.update(buy);}
    public String updateAll(BuyBook buyBook){return buyDao.updateAll(buyBook);}
    public List<Buy> findAll(Integer customer_id){return buyDao.findAll(customer_id);}
    public List<Buy> findAll(){
        return buyDao.findAll();
    }
    public List<Buy> findTime(Date date){
        return buyDao.findTime(date);
    }
    public List<Buy> findByIdTime(Integer id,Date date){
        return buyDao.findByIdTime(id,date);
    }
}
