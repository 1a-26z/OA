package com.online_shop.repository;

import com.online_shop.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomizedOrderRepository {

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customer_id")
    List<Order> getOrdersByCustomer(@Param("customer_id") Long customer_id);
}
