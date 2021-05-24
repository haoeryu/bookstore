package com.bookstore.springtest.daoimpl;

import com.bookstore.springtest.dao.CustomerDao;
import com.bookstore.springtest.entity.Book;
import com.bookstore.springtest.entity.Bookadmin;
import com.bookstore.springtest.entity.Customer;
import com.bookstore.springtest.entity.CustomerIcon;
import com.bookstore.springtest.repository.BookadminRepository;
import com.bookstore.springtest.repository.CustomerIconRepository;
import com.bookstore.springtest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerIconRepository customerIconRepository;
    @Autowired
    private BookadminRepository bookadminRepository;

    public String update(Customer customer){
        Customer result = customerRepository.save(customer);
        if(result != null)
        {
            return "success";
        }else {
            return "error";
        }
    }

    public String ban(String username){
        List<Customer> user = customerRepository.findByUsername(username);
        user.get(0).setLog(0);
        Customer result = customerRepository.save(user.get(0));
        if(result != null)
        {
            return "success";
        }else {
            return "error";
        }
    }
    public String unban(String username){
        List<Customer> user = customerRepository.findByUsername(username);
        user.get(0).setLog(1);
        System.out.println(user.get(0));
        Customer result = customerRepository.save(user.get(0));
        if(result != null)
        {
            return "success";
        }else {
            return "error";
        }
    }
    public String save(Customer customer){
        List<Bookadmin> admin = bookadminRepository.findByUsername(customer.getUsername());
        List<Customer> user = customerRepository.findByUsername(customer.getUsername());
        if(!admin.isEmpty()||!user.isEmpty())
        {
            return "contain";
        }
        customer.setLog(1);
        Customer result = customerRepository.save(customer);
        if(result != null)
        {
            return "success";
        }else {
            return "error";
        }
    }

    public List<Customer> findAll(){return customerRepository.findAll();}

    public String loginCheck(Customer customer, HttpSession session){
        List<Bookadmin> admin = bookadminRepository.findByUsername(customer.getUsername());
        if(!admin.isEmpty())
        {
            System.out.println(admin.get(0).getUsername());
            return "0";//用户是管理员
        }else {
            List<Customer> result = customerRepository.findByUsername(customer.getUsername());
//        Customer result = customerRepository.save(customer);

            if (result.isEmpty()) {
                return "1";//用户名不存在
            } else if (!result.get(0).getPassword().equals(customer.getPassword())) {
                return "2";//密码错误
            }
            else if (result.get(0).getLog().equals(0)) {
                return "3";//用户被禁止
            }
            else {
                session.setAttribute("user",result.get(0).getName());
                return "success+" + result.get(0).getId() + "+" + result.get(0).getName();//登录成功
            }
        }
    }
//    public Customer loginCheck(){
//        List<Customer> result = customerRepository.findByUsername("username00");
//        return result.get(0);
//    }
    public Customer findOne(Integer _id){
        Customer customer = customerRepository.getOne(_id);
       Optional <CustomerIcon> icon=customerIconRepository.findById(_id.toString());
        if(icon.isPresent()){
            customer.setIcon(icon.get().getCustomerIcon());
            System.out.println("Not Null " + _id);
        }else {
            customer.setIcon(null);
            System.out.println("It's Null");
        }
//        customer.setIcon("this");
//        System.out.println(customer.getIcon());
        return  customer;
    }

    public Page<Customer> findAll(Pageable pageable){return customerRepository.findAll(pageable);}
}
