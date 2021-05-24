package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.Shoppingcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingcartRepository extends JpaRepository<Shoppingcart,Integer> {
    public Shoppingcart   findByCustomeridAndBookidEquals(Integer customerid,Integer bookid);
    public List<Shoppingcart> findByCustomeridEquals(Integer customerid);
    @Query(nativeQuery = false,value = " SELECT p FROM Shoppingcart p WHERE p.customerid = :id ")
    List<Shoppingcart> getBook_id(Integer id);
}
