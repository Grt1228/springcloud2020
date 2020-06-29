package com.unfbx.springcloud.service.impl;

import com.unfbx.springcloud.dao.PaymentDao;
import com.unfbx.springcloud.entity.Payment;
import com.unfbx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @author grt
 * @date 2020-06-29
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
