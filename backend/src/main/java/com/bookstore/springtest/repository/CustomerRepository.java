package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
//    @Query("select " +
//            "p.username as username," +
//            "p.password as password " +
//            "from Customer p where username = :username")
//    List<Customer> queryUserName(@Param("username") String username);
    public List<Customer> findByUsername(String username);
}
