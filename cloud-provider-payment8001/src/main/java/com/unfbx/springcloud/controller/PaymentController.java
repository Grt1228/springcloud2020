package com.unfbx.springcloud.controller;

/**
 * 描述：
 *
 * @author grt
 * @date 2020-06-30
 */

import com.unfbx.springcloud.entity.CommonResult;
import com.unfbx.springcloud.entity.Payment;
import com.unfbx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/create")

    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入返回值：{}", i);
        if(i > 0){
            return new CommonResult(200,"成功，端口号："+serverPort,i);
        }
        return new CommonResult(444,"失败",null);

    }

    @GetMapping(value = "/{id}")
    public CommonResult<Payment> findById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment == null){
            return new CommonResult(444,"失败",null);
        }
        return new CommonResult(200,"成功，端口号："+serverPort,payment);
    }



    @GetMapping(value = "/discovery")
    public Object getInfo(){
        //获取服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务信息：{}"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId() + " - " +instance.getHost() + " - " + instance.getPort()
                            + " - " +instance.getUri() );
        }
        return this.discoveryClient;
    }
}
