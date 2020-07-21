package in.hocg.payment.gateway.modules.bmw.helper.payment.resolve.message.rule.payment;

import in.hocg.payment.alipay.v2.AliPayService;
import in.hocg.payment.alipay.v2.message.TradeStatusSyncMessage;
import in.hocg.payment.convert.StringConvert;
import in.hocg.payment.gateway.basic.constant.CodeEnum;
import in.hocg.payment.gateway.basic.constant.PaymentWay;
import in.hocg.payment.gateway.basic.constant.TradeStatus;
import in.hocg.payment.gateway.basic.ext.web.SpringContext;
import in.hocg.payment.gateway.modules.bmw.helper.payment.resolve.message.MessageContext;
import in.hocg.payment.gateway.modules.bmw.pojo.ro.PaymentMessageRo;
import in.hocg.payment.gateway.modules.bmw.service.PaymentService;
import in.hocg.payment.gateway.utils.DateUtils;
import in.hocg.payment.gateway.utils.LangUtils;
import in.hocg.payment.gateway.utils.lambda.map.LambdaMap;
import in.hocg.payment.resolve.StringResolve;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by hocgin on 2019/12/21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class AliPayPaymentMessageRule extends StringResolve.StringRule<TradeStatusSyncMessage, TradeStatusSyncMessage.Result> {
    public AliPayPaymentMessageRule(AliPayService payService) {
        super(new StringConvert<TradeStatusSyncMessage>() {
            @Override
            public <R extends TradeStatusSyncMessage> R convert(String body, Class<R> clazz) {
                return payService.message(URLDecoder.decode(body), clazz);
            }
        }, AliPayPaymentMessageRule::handleMessage);

    }

    protected static TradeStatusSyncMessage.Result handleMessage(TradeStatusSyncMessage message, Map<String, Object> args) {
        try {
            final LambdaMap<Object> lambdaMap = (LambdaMap<Object>) args;
            final String appid = lambdaMap.getAsString(MessageContext::getAppid);
            final Integer channel = lambdaMap.getAsInt(MessageContext::getPlatformTyp);
            final Integer feature = lambdaMap.getAsInt(MessageContext::getFeature);
            final PaymentWay paymentWay = CodeEnum.of(lambdaMap.getAsInt(MessageContext::getPaymentWay), PaymentWay.class).orElse(PaymentWay.Unknown);

            final String outTradeNo = message.getOutTradeNo();
            final String tradeNo = message.getTradeNo();
            final TradeStatus tradeStatus = AliPayPaymentMessageRule.convertStatus(message.getTradeStatus());
            final LocalDateTime paymentAt = AliPayPaymentMessageRule.convertDatetime(message.getGmtPayment());
            final String totalAmount = message.getTotalAmount();
            final String buyerPayAmount = message.getBuyerPayAmount();
            final PaymentMessageRo ro = new PaymentMessageRo()
                .setAppid(LangUtils.getOrDefault(message.getAppId(), appid))
                .setTradeStatus(tradeStatus)
                .setTradeNo(tradeNo)
                .setTradeSn(outTradeNo)
                .setPaymentAt(paymentAt)
                .setTotalFee(new BigDecimal(totalAmount))
                .setBuyerPayFee(new BigDecimal(buyerPayAmount))
                .setPlatformType(channel)
                .setPaymentWay(paymentWay);

            SpringContext.getBean(PaymentService.class).handlePaymentMessage(ro);
            return TradeStatusSyncMessage.Result.builder().result("success").build();
        } catch (Exception e) {
            return TradeStatusSyncMessage.Result.builder().result("fail").build();
        }
    }

    private static TradeStatus convertStatus(String tradeStatus) {
        switch (tradeStatus) {
            case "TRADE_SUCCESS":
                return TradeStatus.Success;
            case "TRADE_CLOSED":
                return TradeStatus.Closed;
            default:
                return TradeStatus.Fail;
        }
    }

    static LocalDateTime convertDatetime(String datetime) {
        return DateUtils.format(datetime, DateUtils.DATE_FORMAT_2);
    }
}
