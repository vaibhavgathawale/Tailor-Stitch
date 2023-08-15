package com.tailor.service;

import com.tailor.dao.CustomerDao;
import com.tailor.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer saveCustomer(Customer customer){
        return customerDao.save(customer);
    }


    public Iterable<Customer> listOfCustomerDetails(){
        return customerDao.findAll();
    }


    public Customer deleteCustomer(String serialNumber){
        Optional<Customer> cmp =  customerDao.findById(serialNumber);
        if(cmp.isPresent()){
            customerDao.deleteById(serialNumber);
            return  null;

        }else {
            return  null;
        }
    }
    public Customer updateCustomerById(String serialNumber){
        Optional<Customer> cmp = customerDao.findById(serialNumber);
        return cmp.get();
    }
}
