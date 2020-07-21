package in.hocg.payment.gateway.modules.bmw.service;

import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractService;
import in.hocg.payment.gateway.modules.bmw.api.vo.PaymentWayVo;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentWayRule;

import java.util.List;

/**
 * <p>
 * [支付网关] 支付渠道规则表 服务类
 * </p>
 *
 * @author hocgin
 * @since 2020-07-18
 */
public interface PaymentWayRuleService extends AbstractService<PaymentWayRule> {

    List<PaymentWayVo> queryPaymentWay(Long appId, String sceneCode);
}
