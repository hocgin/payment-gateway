package in.hocg.payment.gateway.modules.bmw.service;

import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractService;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentTrade;

import java.util.Optional;

/**
 * <p>
 * [支付网关] 交易流水表 服务类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
public interface PaymentTradeService extends AbstractService<PaymentTrade> {

    Optional<PaymentTrade> selectOneByTradeSn(String tradeSn);

    boolean updateOneByIdAndTradeStatus(PaymentTrade update, Long tradeId, Integer... tradeStatus);

}
