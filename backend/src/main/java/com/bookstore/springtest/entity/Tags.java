package com.bookstore.springtest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Tags {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Integer id;
        private String tag;
        private String name;
}
