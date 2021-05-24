package com.bookstore.springtest.daoimpl;

import com.bookstore.springtest.dao.ShoppingcartDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.BookIcon;
import com.bookstore.springtest.entity.Shoppingcart;
import com.bookstore.springtest.repository.BookIconRepository;
import com.bookstore.springtest.repository.BookRepository;
import com.bookstore.springtest.repository.ShoppingcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingcartDaoImpl implements ShoppingcartDao {
    @Autowired
    private ShoppingcartRepository shoppingcartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookIconRepository bookIconRepository;

    @Override
    public String update(Shoppingcart shoppingcart){
        Shoppingcart resultIsExits = shoppingcartRepository.findByCustomeridAndBookidEquals(shoppingcart.getCustomerid(),shoppingcart.getBook_id());
        if(resultIsExits == null){
        Shoppingcart result = shoppingcartRepository.save(shoppingcart);
        if(result != null)
        {
            return "success";
        }else {
            return "error";
        } } else{
            return "exits";
        }
    }

    public List<Book> findAll(Integer customer_id){
        List<Shoppingcart> result = shoppingcartRepository.getBook_id(customer_id);
        List<Book> finalResult = new ArrayList<>();
//        System.out.println(result.get(0).getBook_id());
        for (int i=0;i < result.size();i++)
        {
            Book resultBook = bookRepository.findById(result.get(i).getBook_id()).get();
            BookIcon resultBookIcon = bookIconRepository.findById(result.get(i).getBook_id().toString()).get();
            resultBook.setBook_image(resultBookIcon.getBook_image());
//            System.out.print(resultBook);
            finalResult.add(resultBook);
//            System.out.println("here");
//            System.out.print(finalResult);
        }
//        System.out.print(finalResult);
//        System.out.print("dao");
        return finalResult;
    }
    public List<Shoppingcart> findAll(){return shoppingcartRepository.findAll();}

    public void deleteOne(Integer cusid,Integer bookid){
        Shoppingcart shop = shoppingcartRepository.findByCustomeridAndBookidEquals(cusid,bookid);
         shoppingcartRepository.deleteById(shop.getId());

    }
    public void deleteAll(Integer id){
        List<Shoppingcart> shop = shoppingcartRepository.findByCustomeridEquals(id);
        for(int i=0;i<shop.size();i++)
        {
            shoppingcartRepository.deleteById(shop.get(i).getId());
        }
    }
}
