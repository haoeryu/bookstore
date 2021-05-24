package com.bookstore.springtest.controller;


import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Tag;
import com.bookstore.springtest.entity.Tags;
import com.bookstore.springtest.repository.BookRepository;
import com.bookstore.springtest.repository.TagRepository;
import com.bookstore.springtest.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagHandler {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagsRepository tagsRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findByName/{tag}")
    public List<Book> findByTag(@PathVariable("tag") String tag) {
        List<Book> ret = new LinkedList<Book>();
        List<Tag> tags = tagRepository.getTagsWithTwoRelation(tag);
        List<String> tagNames = new LinkedList<String>();
        int size = tags.size();
        String str;
        for(int i=0; i < size; i++)
        {
           str = tags.get(i).getName();
            System.out.println(str);
            if(i == 0)
            {
                tagNames.add(str);
            }

            if(!tagNames.contains(str))
           {
               tagNames.add(str);
           }
           List<Tag> tags1 =tagRepository.getTagsWithTwoRelation(str);
           System.out.println("tags1:"+tags1);
           int size1 = tags1.size();
           for(int j=0;j<size1;j++)
           {
               str = tags1.get(j).getName();
               if(!tagNames.contains(str))
               {
                   tagNames.add(str);
               }
           }
        }
        int size2 = 0;
        if(tagNames!=null) {
             size2 = tagNames.size();
        }
        System.out.println(tagNames);

        for(int i = 0; i < size2;i++)
        {
           List<Tags> tag2Book = tagsRepository.findAllByTag(tagNames.get(i));
           System.out.println("tag2Book"+tag2Book);
           int size3 = tag2Book.size();
           for(int j=0;j<size3;j++)
           {
               Book book = bookRepository.findByName(tag2Book.get(j).getName());
               if(j == 0)
               {
                   ret.add(book);
               }
               if(!ret.contains(book))
               {
                   ret.add(book);
               }
           }
        }

        return ret;
    }
}
