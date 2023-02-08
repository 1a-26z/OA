package com.online_shop.entity.DTO;

import com.online_shop.entity.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class OrderDTO {
    private LocalDateTime localDateTime;

    private BigDecimal amount;

    private Long customer_id;

    public OrderDTO(Order order) {
        this.localDateTime = order.getLocalDateTime();
        this.amount = order.getAmount();
        this.customer_id = order.getCustomer().getId();
    }
}
