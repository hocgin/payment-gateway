package in.hocg.payment.gateway.modules.bmw.service;


import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractService;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentApp;

import java.util.Optional;

/**
 * <p>
 * [支付网关] 接入方表 服务类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
public interface PaymentAppService extends AbstractService<PaymentApp> {

    Optional<PaymentApp> selectOneByAppSn(Long appSn);
}
