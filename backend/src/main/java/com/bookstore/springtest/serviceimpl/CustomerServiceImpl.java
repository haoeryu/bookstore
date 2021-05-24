package com.bookstore.springtest.serviceimpl;

import com.bookstore.springtest.dao.CustomerDao;
import com.bookstore.springtest.entity.Customer;
import com.bookstore.springtest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public String update(Customer customer){return customerDao.update(customer);}
    public String save(Customer customer){return customerDao.save(customer);}
    public List<Customer> findAll(){return  customerDao.findAll();}
    public String loginCheck(Customer customer, HttpSession session){return customerDao.loginCheck(customer,session);}
    public Customer findCustomerById(Integer id){return customerDao.findOne(id);}
    public Page<Customer> findAll(Pageable pageable){return customerDao.findAll(pageable);}
    public String ban(String username){return customerDao.ban(username);}
    public String unban(String username){return customerDao.unban(username);}
//    public Customer loginCheck(){return customerDao.loginCheck();}
}
