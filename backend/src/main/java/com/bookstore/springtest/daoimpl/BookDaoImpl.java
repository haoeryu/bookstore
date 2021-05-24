package com.bookstore.springtest.daoimpl;

import com.bookstore.springtest.dao.BookDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.BookIcon;
import com.bookstore.springtest.entity.Bookadmin;
import com.bookstore.springtest.repository.BookIconRepository;
import com.bookstore.springtest.repository.BookRepository;
import com.bookstore.springtest.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookIconRepository bookIconRepository;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public Book findById(Integer id){
        Book book=bookRepository.findById(id).get();
        BookIcon bookIcon=bookIconRepository.findById(id.toString()).get();
        book.setBook_image(bookIcon.getBook_image());
        book.setBookComment(bookIcon.getBookComment());
        return book;
    }

    public List<Book> findLike(String booklike){
        List<Book> book=bookRepository.findByNameContains(booklike);
        for(int i=0;i<book.size();i++)
        {
            BookIcon bookIcon=bookIconRepository.findById(book.get(i).getId().toString()).get();
            book.get(i).setBook_image(bookIcon.getBook_image());
        }
        return  book;
    }

    public Book findByName(String book){
        Book bookRet = null;
        bookRet = (Book) redisUtils.get(book);
        if(bookRet!=null)
        {
            System.out.println("bookRet:"+bookRet);
            return bookRet;
        }else{
            bookRet = bookRepository.findByName(book);
            return bookRet;
        }
    }

    public Page<Book> findAll(Pageable pageable){
        List<Book> book=bookRepository.findAll();

        for(int i=0;i<book.size();i++)
        {
            book.get(i).setBook_image(bookIconRepository.findById(book.get(i).getId().toString()).get().getBook_image());
        }
        Page<Book> bookpage = new PageImpl(book,pageable,book.size());
        return bookpage;
    }

    public String save(Book book){

        Book result = bookRepository.save(book);
        redisUtils.set(book.getName(),book);
        if(result != null)
        {
//            Book nowbook = bookRepository.findByName(book.getName());
            BookIcon bookIcon = new BookIcon(book.getId().toString(),book.getBookComment(),book.getBook_image());
            BookIcon iconresult = bookIconRepository.save(bookIcon);
            if(iconresult!=null)
            return "success";
        }else {
            return "error";
        }
        return "error";
    }

    public String update(Book book){
        Book prebook = bookRepository.findByName(book.getPrename());
        BookIcon prebookIcon =bookIconRepository.findById(prebook.getId().toString()).get();
        if(!book.getName().equals("")) { prebook.setName(book.getName()); }
        if(!book.getAuthor().equals("")) {prebook.setAuthor(book.getAuthor());}
        if(!book.getSerial().equals("")){prebook.setSerial(book.getSerial());}
        if(book.getAbled()!= null){prebook.setAbled(book.getAbled());}
        if(!book.getBook_image().equals("")){prebookIcon.setBook_image(book.getBook_image());}
        Book result = bookRepository.save(prebook);
        BookIcon iconresult = bookIconRepository.save(prebookIcon);
        //redisUtils.getAndSet(book.getName(),book);
        redisUtils.del(book.getName());
        redisUtils.set(book.getName(),book);
        if(result != null && iconresult!=null)
        {
            return "success";
        }else {
            return "error";
        }
    }

    public  void deleteById(Integer id){
        bookRepository.deleteById(id);
    }
    public void deleteByName(String name){
        Book book=bookRepository.findByName(name);
        bookRepository.deleteById(book.getId());
        bookIconRepository.deleteById(book.getId().toString());
        redisUtils.del(book.getName());
    }

    public List<Book> findAll(){
        List<Book> books = bookRepository.findAll();
        List<BookIcon> bookIcons = bookIconRepository.findAll();
        for(int i=0;i<books.size();i++)
        {
            books.get(i).setBookComment(bookIcons.get(i).getBookComment());
            books.get(i).setBook_image(bookIcons.get(i).getBook_image());
        }
        return books;
    }
}
