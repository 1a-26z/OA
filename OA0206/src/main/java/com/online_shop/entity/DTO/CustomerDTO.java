package com.online_shop.entity.DTO;

import com.online_shop.entity.Customer;
import lombok.Data;

@Data
public class CustomerDTO {
    private String last_name;

    private String first_name;

    public CustomerDTO(Customer customer) {
        this.first_name = customer.getFirst_name();
        this.last_name = customer.getLast_name();
    }
}
