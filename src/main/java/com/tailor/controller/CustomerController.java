package com.tailor.controller;

import com.tailor.model.Customer;
import com.tailor.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tailor")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/custlist")
    public String getCustomerList(){

        return customerService.listOfCustomerDetails().toString();
    }

    @DeleteMapping("/custdelete/{serialNumber}")
    public ResponseEntity<?> removeCompany(@PathVariable String serialNumber){
        customerService.deleteCustomer(serialNumber);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/custupdate{serialNumber}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable ("serialNumber") String serialNumber){
        customerService.updateCustomerById(serialNumber);
        return  new ResponseEntity(serialNumber,HttpStatus.OK);
    }


}
