package com.bookstore.springtest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Bookadmin {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    public  Integer getId(){return id;}
    public  String getUsername(){return  username;}
    public  String getPassword(){return  password;}
}
