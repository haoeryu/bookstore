package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tags,Integer> {
     List<Tags> findAllByTag(String tag);
}
