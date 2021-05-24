package com.bookstore.springtest.serviceimpl;

import com.bookstore.springtest.dao.BookDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book findById(Integer id){return bookDao.findById(id);}
    public Page<Book> findAll(Pageable pageable){return bookDao.findAll(pageable);}
    public String save(Book book){return bookDao.save(book);}
    public String update(Book book){return bookDao.update(book);}
    public void deleteById(Integer id){bookDao.deleteById(id);}
    public List<Book> findAll(){return bookDao.findAll();}
    public List<Book> findLike(String booklike){return bookDao.findLike(booklike);}
    public Book findByName(String book){return bookDao.findByName(book);}
    public void deleteByName(String name){bookDao.deleteByName(name);}
}
