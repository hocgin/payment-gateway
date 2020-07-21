package in.hocg.payment.gateway.modules.bmw.service;

import in.hocg.payment.gateway.basic.constant.Enabled;
import in.hocg.payment.gateway.basic.constant.PaymentWay;
import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractService;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentPlatform;

import java.util.Optional;

/**
 * <p>
 * [支付网关] 支付平台表 服务类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
public interface PaymentPlatformService extends AbstractService<PaymentPlatform> {

    Optional<PaymentPlatform> selectOneByTradeIdAndPaymentWayAndStatus(Long tradeId, PaymentWay paymentWay, Enabled enabled);

    Optional<PaymentPlatform> selectOneByPlatformAppidAndPlatformType(String platformAppid, Integer platformType);
}
