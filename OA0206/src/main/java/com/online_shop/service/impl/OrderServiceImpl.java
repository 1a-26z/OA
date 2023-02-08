package com.online_shop.service.impl;

import com.online_shop.entity.DTO.OrderDTO;
import com.online_shop.entity.Order;
import com.online_shop.exception.ResourceNotFoundException;
import com.online_shop.repository.OrderRepository;
import com.online_shop.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public OrderDTO createOrder(Order order) throws Exception {
        orderRepository.save(order);
        return new OrderDTO(order);
    }

    @Override
    public OrderDTO findOrderById(Long id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            logger.info("cannot find customer" + id);
            throw new ResourceNotFoundException("order not found");
        }
        return new OrderDTO(order.get());
    }
}
