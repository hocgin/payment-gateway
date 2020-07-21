package in.hocg.payment.gateway.modules.bmw.datastruct;

import in.hocg.payment.gateway.modules.bmw.api.vo.PaymentWayVo;
import in.hocg.payment.gateway.modules.bmw.entity.PaymentWayRuleItem;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by hocgin on 2020/7/18.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper(componentModel = "spring")
public interface PaymentWayRuleItemMapping {

    List<PaymentWayVo> asPaymentWayVo(List<PaymentWayRuleItem> result);

    PaymentWayVo asPaymentWayVo(PaymentWayRuleItem result);


}
