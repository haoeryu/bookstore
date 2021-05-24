package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BuyRepository extends JpaRepository<Buy,Integer> {
    public List<Buy> findByBuytimeGreaterThanEqual(Date date);
    @Query(nativeQuery = false,value = " SELECT p FROM Buy p WHERE p.customer_id = :id ")
    List<Buy> getBook_id(Integer id);

}
