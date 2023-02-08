package com.online_shop.service.impl;

import com.online_shop.entity.Customer;
import com.online_shop.entity.Order;
import com.online_shop.exception.ResourceNotFoundException;
import com.online_shop.repository.CustomerRepository;
import com.online_shop.repository.OrderRepository;
import com.online_shop.service.CustomerService;
import com.online_shop.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {
    private static Logger logger = LoggerFactory.getLogger(RewardService.class);

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    @Autowired
    public RewardServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, CustomerService customerService) {

        this.orderRepository = orderRepository;

        this.customerRepository = customerRepository;
    }

    private BigDecimal amountToRewards(BigDecimal amount) {
        return new BigDecimal(0).max(amount.subtract(new BigDecimal(50)))
                .add(
                new BigDecimal(0).max(amount.subtract((new BigDecimal(100))))
                );
    }

    @Override
    public BigDecimal getRewardsByMonth(Long id, int month) throws Exception {
//        if (!customerRepository.existsById(id)) {
//            throw new ResourceNotFoundException("cannot find customer" + id);
//        }
        List<Order> orderList = orderRepository.getOrdersByCustomer(id);
        List<BigDecimal> rewardsList = orderList
                .stream()
                .filter(o -> o.getLocalDateTime().getMonthValue() == month)
                .map(o -> amountToRewards(o.getAmount()))
                .collect(Collectors.toList());
        BigDecimal rewardSum = new BigDecimal(0);
        for (BigDecimal reward : rewardsList) {
            rewardSum.add(reward);
        }
        return rewardSum;
    }

    @Override
    public BigDecimal getTotalRewards(Long id) throws Exception {
        List<Order> orderList = orderRepository.getOrdersByCustomer(id);
        List<BigDecimal> rewardsList = orderList
                .stream()
                .filter(o -> o.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(3)))
                .map(o -> amountToRewards(o.getAmount()))
                .collect(Collectors.toList());
        BigDecimal rewardSum = new BigDecimal(0);
        for (BigDecimal reward : rewardsList) {
            rewardSum.add(reward);
        }
        return rewardSum;
    }
}
