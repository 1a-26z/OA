package com.online_shop.service;

import com.online_shop.entity.DTO.OrderDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface RewardService {
    public BigDecimal getRewardsByMonth(Long id, int month) throws Exception;

    public BigDecimal getTotalRewards(Long id) throws Exception;
}
