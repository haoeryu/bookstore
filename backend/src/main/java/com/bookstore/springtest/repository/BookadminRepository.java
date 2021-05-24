package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.Bookadmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookadminRepository extends JpaRepository<Bookadmin,Integer> {
    public List<Bookadmin> findByUsername(String username);
}
