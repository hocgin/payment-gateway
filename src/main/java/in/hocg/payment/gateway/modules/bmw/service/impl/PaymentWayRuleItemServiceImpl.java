package in.hocg.payment.gateway.modules.bmw.service.impl;

import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractServiceImpl;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentWayRuleItem;
import in.hocg.payment.gateway.modules.bmw.mapper.PaymentWayRuleItemMapper;
import in.hocg.payment.gateway.modules.bmw.service.PaymentWayRuleItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <p>
 * [支付网关] 支付渠道规则对应的支付渠道表 服务实现类
 * </p>
 *
 * @author hocgin
 * @since 2020-07-18
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class PaymentWayRuleItemServiceImpl extends AbstractServiceImpl<PaymentWayRuleItemMapper, PaymentWayRuleItem> implements PaymentWayRuleItemService {

}
