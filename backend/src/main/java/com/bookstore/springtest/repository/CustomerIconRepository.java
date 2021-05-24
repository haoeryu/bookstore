package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.CustomerIcon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CustomerIconRepository extends MongoRepository<CustomerIcon,String> {
}
