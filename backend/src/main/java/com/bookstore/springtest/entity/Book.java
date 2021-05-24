package com.bookstore.springtest.entity;

import lombok.Data;

import javax.persistence.*;
import java.beans.Transient;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Float price ;
    private Integer abled;
    private String serial;

    public void setAbled(Integer abled){this.abled = abled;}
    private transient Integer buynum=1;
    public Integer getBuynum(){return this.buynum;}
    private transient String prename;
    public String getPrename(){return this.prename;}
    private transient String bookComment;
    private transient String book_image;
//    @Transient
    public void setBookComment(String bookComment){this.bookComment = bookComment;}
    public String getBookComment(){return bookComment;}
//    @Transient
    public void setBook_image(String book_image){this.book_image = book_image;}
    public String getBook_image(){return book_image;}

}
