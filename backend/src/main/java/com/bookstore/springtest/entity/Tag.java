package com.bookstore.springtest.entity;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;

    public String getName(){return name;}
}
