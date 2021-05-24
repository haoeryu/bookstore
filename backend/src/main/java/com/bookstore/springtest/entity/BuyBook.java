package com.bookstore.springtest.entity;

import java.sql.Date;
import java.util.List;

public class BuyBook {
    private List<Book> book;
    public void setBook(List<Book> book1){this.book = book1;}
    public List<Book> getBook(){return this.book;}

    private Integer customer_id;
    public void setCustomer_id(Integer id){this.customer_id=id;}
    public Integer getCustomer_id(){return this.customer_id;}

    private Date buytime;
    public void setBuytime(Date time){this.buytime=time;}
    public Date getBuytime(){return this.buytime;}
}
