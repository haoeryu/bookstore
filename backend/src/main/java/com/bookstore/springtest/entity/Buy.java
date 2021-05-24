package com.bookstore.springtest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Buy {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Integer id;
    private Integer book_id;
    private Integer customer_id;
    private Integer buy_num;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date buytime;
    private Integer number;
    public Integer getCustomer_id(){return customer_id;}
    public Integer getBook_id(){return book_id;}
    public Buy(){
    }

    private transient String book_name;
    private transient Float price;
    public void setBook_Name(String bookname){this.book_name = bookname;}
    public void setPrice(Float price){this.price = price;}
}
