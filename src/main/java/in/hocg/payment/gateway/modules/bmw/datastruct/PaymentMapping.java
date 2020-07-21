package in.hocg.payment.gateway.modules.bmw.datastruct;

import in.hocg.payment.gateway.modules.bmw.helper.payment.pojo.response.GoPaymentResponse;
import in.hocg.payment.gateway.modules.bmw.pojo.vo.GoPayVo;
import org.mapstruct.Mapper;

/**
 * Created by hocgin on 2020/6/7.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper(componentModel = "spring")
public interface PaymentMapping {

    GoPayVo asGoPayVo(GoPaymentResponse result);
}
