package in.hocg.payment.gateway.modules.bmw.service;


import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractService;
import in.hocg.payment.gateway.modules.bmw.entity.RefundRecord;

import java.util.Optional;

/**
 * <p>
 * [支付网关] 退款记录表 服务类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
public interface RefundRecordService extends AbstractService<RefundRecord> {

    Optional<RefundRecord> selectOneByRefundSn(String refundSn);

    boolean updateOneByIdAndTradeStatus(RefundRecord updated, Long id, Integer refundStatus);
}
