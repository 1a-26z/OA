package com.online_shop.service;


import com.online_shop.entity.Customer;
import com.online_shop.entity.Order;
import com.online_shop.repository.CustomerRepository;
import com.online_shop.repository.OrderRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RewardServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private RewardService rewardService;

    private Customer customer;

    private Order order;

    @BeforeEach
    public void init() {
        customer = Customer.builder()
                .id(1L)
                .first_name("F")
                .last_name("L")
                .build();
        order = Order.builder()
                .id(1L)
                .amount(new BigDecimal(150))
                .customer(customer)
                .localDateTime(LocalDateTime.now())
                .build();
    }

    @DisplayName("Junit test for getTotalRewards method")
    @Test
    public void validInput() throws Exception{
        given(orderRepository.getOrdersByCustomer(1L)).willReturn(
                        Arrays.asList(new Order[]{order}).stream()
                                .map(o -> (Order) o)
                                .collect(Collectors.toList())
        );

        assertEquals(rewardService.getTotalRewards(1L), new BigDecimal(150));
    }
}
