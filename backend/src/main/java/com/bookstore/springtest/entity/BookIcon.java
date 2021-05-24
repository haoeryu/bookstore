package com.bookstore.springtest.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.persistence.Id;


@Document(collection = "bookIcon")
public class BookIcon {
    @Id
    private String _id;

    @Field("bookComment")
    private String bookComment;
    @Field("book_image")
    private String  book_image;

    public BookIcon(String _id,String bookComment,String book_image)
    {
        this._id = _id;
        this.bookComment = bookComment;
        this.book_image = book_image;
    }

    public String getBookComment(){return  bookComment;}
    public void setBookComment(String bookComment){this.bookComment = bookComment;}

    public String getBook_image(){return book_image;}
    public void setBook_image(String book_image){this.book_image = book_image;}
}
