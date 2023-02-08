package com.online_shop.service;

import com.online_shop.entity.Customer;
import com.online_shop.entity.DTO.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public CustomerDTO createCustomer(Customer customer) throws Exception;

    public CustomerDTO findCustomerById(Long id) throws Exception;
}


