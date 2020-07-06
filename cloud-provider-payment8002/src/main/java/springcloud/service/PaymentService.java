package springcloud.service;

import com.unfbx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：
 *
 * @author grt
 * @date 2020-06-29
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
