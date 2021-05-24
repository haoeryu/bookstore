package com.bookstore.springtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.beans.Transient;


@Entity
@Data
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String tel;
    private String gender;
    private Integer log;
    public  Integer getId(){return id;}
    public  String getUsername(){return  username;}
    public  String getPassword(){return  password;}
    public  String getName(){return  name;}
    public  Integer getLog(){return log;}
    public  void setLog(Integer _log){this.log = _log;}


    private transient String icon;
    @Transient
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getCustomerIcon(){ return icon; }
}
