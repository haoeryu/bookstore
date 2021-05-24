package com.bookstore.springtest.daoimpl;

import com.bookstore.springtest.dao.BuyDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Buy;
import com.bookstore.springtest.entity.BuyBook;
import com.bookstore.springtest.entity.Shoppingcart;
import com.bookstore.springtest.repository.BookRepository;
import com.bookstore.springtest.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class BuyDaoImpl implements BuyDao {
    @Autowired
    private BuyRepository buyRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String update(Buy buy){
        Book book = bookRepository.findById(buy.getBook_id()).get();
        if(book.getAbled()>=buy.getBuy_num())
        {
            book.setAbled(book.getAbled()-buy.getBuy_num());
            bookRepository.save(book);
        }else {
            return "able";
        }
        List<Buy> num = buyRepository.findAll();
        buy.setNumber(num.get(num.size()-1).getNumber()+1);
        Buy result = buyRepository.save(buy);
        if(result != null)
        {
            return "success";
        }else {
            return "error";
        }
    }
    public String updateAll(BuyBook buyBook){
        for(int i=0;i<buyBook.getBook().size();i++)
        {
            if(buyBook.getBook().get(i).getAbled()>=buyBook.getBook().get(i).getBuynum())
            {

            }else {
                return "able";
            }
        }//有一种库存不足 则整单失败
        for(int i=0;i<buyBook.getBook().size();i++)
        {
            buyBook.getBook().get(i).setAbled(buyBook.getBook().get(i).getAbled()-buyBook.getBook().get(i).getBuynum());
            bookRepository.save(buyBook.getBook().get(i));
        }//库存相应减少
        List<Buy> num = buyRepository.findAll();
        int ordernumber = num.get(num.size()-1).getNumber()+1;

        String s = "";

        for(int i=0;i<buyBook.getBook().size();i++)
        {
            Buy buy=new Buy();
            buy.setBuy_num(0);
            buy.setBook_id(-1);
            buy.setCustomer_id(-1);
            buy.setBuytime(buyBook.getBuytime());
            buy.setNumber(ordernumber);
            buy.setBuy_num(buyBook.getBook().get(i).getBuynum());
            buy.setBook_id(buyBook.getBook().get(i).getId());
            buy.setCustomer_id(buyBook.getCustomer_id());
            buy.setBuytime(buyBook.getBuytime());
            buy.setNumber(ordernumber);
            System.out.println(buy.getBook_id());
            System.out.println(buy.getCustomer_id());
            System.out.println(buy.getBuy_num());
            System.out.println(buy.getBuytime());
            System.out.println(buy.getNumber());
            Buy result = buyRepository.save(buy);
            if(result == null)
            {
                s="error";
            }
        }
        if(s.equals("error")){
            return s;
        }else{
            return "success";
        }
    }

    public List<Buy> findAll(Integer customer_id){
        List<Buy> result = buyRepository.getBook_id(customer_id);
//        List<Book> finalResult = new ArrayList<>();
//        for (int i=0;i < result.size();i++)
//        {
//            Book resultBook = bookRepository.findById(result.get(i).getBook_id()).get();
//            finalResult.add(resultBook);
//        }
        setBuy(result);
        return result;
    }

    public List<Buy> findAll(){
        List<Buy> result = buyRepository.findAll();
        setBuy(result);
        return  result;
    }

    public List<Buy> findTime(Date date){
        List<Buy> result= buyRepository.findByBuytimeGreaterThanEqual(date);
        setBuy(result);
        return result;
    }

    public List<Buy> findByIdTime(Integer id,Date date){
        List<Buy> result = buyRepository.findByBuytimeGreaterThanEqual(date);
        for(int i=0;i<result.size();i++){
            if(!result.get(i).getCustomer_id().equals(id))
            {
                result.remove(i);
                i=i-1;
            }
        }
        setBuy(result);
        return result;
    }

    public void setBuy(List<Buy> result){
        for (int i=0;i < result.size();i++)
        {
            Book resultBook = bookRepository.findById(result.get(i).getBook_id()).get();
            result.get(i).setBook_Name(resultBook.getName());
            result.get(i).setPrice(resultBook.getPrice());
        }
    }
}
