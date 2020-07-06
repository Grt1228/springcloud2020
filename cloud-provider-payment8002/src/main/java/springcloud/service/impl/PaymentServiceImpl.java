package springcloud.service.impl;

import com.unfbx.springcloud.entity.Payment;
import org.springframework.stereotype.Service;
import springcloud.dao.PaymentDao;
import springcloud.service.PaymentService;

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
