package com.online_shop.service;

import com.online_shop.entity.DTO.OrderDTO;
import com.online_shop.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public OrderDTO createOrder(Order order) throws Exception;

    public OrderDTO findOrderById(Long id) throws Exception;
}
