package in.hocg.payment.gateway.modules.bmw.mapper;

import in.hocg.payment.gateway.modules.bmw.entity.NotifyApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * [支付网关] 事件通知列表 Mapper 接口
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
@Mapper
public interface NotifyAppMapper extends BaseMapper<NotifyApp> {

}
