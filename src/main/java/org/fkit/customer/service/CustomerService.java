package org.fkit.customer.service;

import org.fkit.customer.bean.Customer;
import org.fkit.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public List<Customer> findNameAndIndustry(String cust_name,String cust_industry){
        return customerRepository.findNameAndIndustry(cust_name,cust_industry);
    }

    public int insertCustomer(Customer customer){
        return customerRepository.insertCustomer(customer);
    }

    public Customer editCustomer(Integer cust_id){
        return customerRepository.editCustomer(cust_id);
    }

    public int updateCustomer(Customer customer){
        return customerRepository.updateCustomer(customer);
    }

    public int deleteCustomer(Integer cust_id){
        return customerRepository.deleteCustomer(cust_id);
    }
}

