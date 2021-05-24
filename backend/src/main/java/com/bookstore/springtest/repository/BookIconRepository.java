package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.BookIcon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookIconRepository extends MongoRepository<BookIcon,String> {

}
