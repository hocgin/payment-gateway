package in.hocg.payment.gateway.modules.bmw.service.impl;

import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractServiceImpl;
import in.hocg.payment.gateway.modules.bmw.entity.RequestPlatformLog;
import in.hocg.payment.gateway.modules.bmw.mapper.RequestPlatformLogMapper;
import in.hocg.payment.gateway.modules.bmw.service.RequestPlatformLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <p>
 * [支付网关] 所有和第三方支付交易日志表 服务实现类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class RequestPlatformLogServiceImpl extends AbstractServiceImpl<RequestPlatformLogMapper, RequestPlatformLog> implements RequestPlatformLogService {

}
