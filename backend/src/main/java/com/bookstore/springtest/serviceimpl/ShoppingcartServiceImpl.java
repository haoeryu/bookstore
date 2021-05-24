package com.bookstore.springtest.serviceimpl;


import com.bookstore.springtest.dao.ShoppingcartDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Shoppingcart;
import com.bookstore.springtest.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class ShoppingcartServiceImpl implements ShoppingcartService {
    @Autowired
    private ShoppingcartDao shoppingcartDao;

    @Override
    public String update(Shoppingcart shoppingcart){return shoppingcartDao.update(shoppingcart);}
    public List<Book> findAll(Integer customer_id){
//        System.out.println(customer_id);
//        System.out.print("service");
        return shoppingcartDao.findAll(customer_id);}
        public List<Shoppingcart> findAll(){return shoppingcartDao.findAll();}
        public void deleteOne(Integer cusid,Integer bookid){shoppingcartDao.deleteOne(cusid,bookid);}
        public void deleteAll(Integer id){shoppingcartDao.deleteAll(id);}
}
