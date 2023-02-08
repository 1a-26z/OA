package com.online_shop.service.impl;

import com.online_shop.entity.Customer;
import com.online_shop.entity.DTO.CustomerDTO;
import com.online_shop.exception.ResourceNotFoundException;
import com.online_shop.repository.CustomerRepository;
import com.online_shop.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final static Logger logger  = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public CustomerDTO createCustomer(Customer customer) throws Exception {
        customerRepository.save(customer);
        return new CustomerDTO(customer);
    }

    @Override
    public CustomerDTO findCustomerById(Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            logger.info("cannot find customer by " + id);
            throw new ResourceNotFoundException("customer not found");
        }
        return new CustomerDTO(customer.get());
    }
}
