package in.hocg.payment.gateway.modules.bmw.service.impl;

import in.hocg.payment.gateway.basic.constant.*;
import in.hocg.payment.gateway.basic.exception.ServiceException;
import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractServiceImpl;
import in.hocg.payment.gateway.modules.bmw.entity.NotifyApp;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentTrade;
import in.hocg.payment.gateway.modules.bmw.entity.RefundRecord;
import in.hocg.payment.gateway.modules.bmw.mapper.NotifyAppMapper;
import in.hocg.payment.gateway.modules.bmw.service.NotifyAppService;
import in.hocg.payment.gateway.modules.bmw.service.PaymentTradeService;
import in.hocg.payment.gateway.modules.bmw.service.RefundRecordService;
import in.hocg.payment.gateway.utils.ValidUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * [支付网关] 事件通知列表 服务实现类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class NotifyAppServiceImpl extends AbstractServiceImpl<NotifyAppMapper, NotifyApp> implements NotifyAppService {
    private final PaymentTradeService paymentTradeService;
    private final RefundRecordService refundRecordService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long savePaymentNotify(Long tradeId) {
        final PaymentTrade paymentTrade = paymentTradeService.getById(tradeId);
        ValidUtils.notNull(paymentTrade, "交易单据不存在");
        final TradeStatus status = CodeEnum.of(paymentTrade.getTradeStatus(), TradeStatus.class)
            .orElseThrow(() -> ServiceException.wrap("交易状态错误"));

        final PaymentNotifyStatus notifyStatus = status.asPaymentNotifyStatus();
        final String tradeSn = paymentTrade.getTradeSn();
        final NotifyApp entity = new NotifyApp()
            .setNotifyType(PaymentNotifyType.Trade.getCode())
            .setNotifyStatus(notifyStatus.getCode())
            .setTradeSn(tradeSn)
            .setRequestSn(tradeSn)
            .setCreatedAt(LocalDateTime.now());
        this.validInsert(entity);
        return entity.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveRefundNotify(Long refundId) {
        final RefundRecord refundRecord = refundRecordService.getById(refundId);
        ValidUtils.notNull(refundRecord, "退款单据不存在");
        final RefundStatus status = CodeEnum.of(refundRecord.getRefundStatus(), RefundStatus.class)
            .orElseThrow(() -> ServiceException.wrap("交易状态错误"));
        final String tradeSn = refundRecord.getTradeSn();

        final PaymentNotifyStatus notifyStatus = status.asPaymentNotifyStatus();
        final NotifyApp entity = new NotifyApp()
            .setNotifyType(PaymentNotifyType.Refund.getCode())
            .setNotifyStatus(notifyStatus.getCode())
            .setTradeSn(tradeSn)
            .setRequestSn(refundRecord.getRefundSn())
            .setCreatedAt(LocalDateTime.now());
        this.validInsert(entity);
        return entity.getId();
    }
}
