package com.logistics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.logistics.service.LogisticsService;
import common.entities.CommonResult;
import common.entities.Logistics;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logistics")
@AllArgsConstructor
public class LogisticsController {

    private final LogisticsService logisticsService;

    @GetMapping("/find")
    public CommonResult<Logistics> findLogistics(String orderNumber) throws JsonProcessingException {
        Logistics logistics = logisticsService.findLogistics(orderNumber);
        return new CommonResult<Logistics>("200","Success",logistics);
    }
}
