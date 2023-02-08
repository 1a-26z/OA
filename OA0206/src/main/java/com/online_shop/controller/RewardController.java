package com.online_shop.controller;

//import org.springframework.stereotype.Controller;
import com.online_shop.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/rewards")
public class RewardController {
    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    //TODO: id, month -> rewards of month
    @GetMapping
    public ResponseEntity<BigDecimal> getRewardsByMonth(@RequestParam Long id, @RequestParam int month) throws Exception {
        return new ResponseEntity<>(rewardService.getRewardsByMonth(id, month), HttpStatus.OK);
    }

    //TODO: id -> total rewards
    @GetMapping("/all")
    public ResponseEntity<BigDecimal> getTotalRewards(@RequestParam Long id) throws Exception {
        return new ResponseEntity<>(rewardService.getTotalRewards(id), HttpStatus.OK);
    }


//    @GetMapping
//    public String test(@RequestParam String param1, @RequestParam String param2) {
//        return param1 + param2;
//    }
}
