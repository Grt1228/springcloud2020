package com.unfbx.springcloud.controller;

import com.unfbx.springcloud.entity.CommonResult;
import com.unfbx.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @author grt
 * @date 2020-07-01
 */

@RestController
@RequestMapping("/customer/payment")
@Slf4j
public class OrderController {

    //private static final String URL = "http://localhost:8001";
    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL+"/payment/"+id,CommonResult.class);
    }

}
