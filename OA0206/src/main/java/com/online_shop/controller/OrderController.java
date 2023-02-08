package com.online_shop.controller;

import com.online_shop.entity.DTO.OrderDTO;
import com.online_shop.entity.Order;
import com.online_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(Order order) throws Exception {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }
}
