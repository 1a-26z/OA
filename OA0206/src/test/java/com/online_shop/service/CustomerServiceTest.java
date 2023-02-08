package com.online_shop.service;

import com.online_shop.exception.ResourceNotFoundException;
import com.online_shop.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @DisplayName("no customer found test")
    @Test
    public void notFound() {
        given(customerRepository.findById(1L)).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> customerService.findCustomerById(1L));
    }
}
