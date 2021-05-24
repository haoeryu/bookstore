package com.bookstore.springtest.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Shoppingcart {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Integer id;
    private Integer bookid;
    private Integer customerid;
    public  Integer getBook_id(){return bookid;}
}
