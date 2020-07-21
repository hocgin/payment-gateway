package in.hocg.payment.gateway.modules.bmw.service.impl;

import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractServiceImpl;
import in.hocg.payment.gateway.modules.bmw.entity.NotifyAppLog;
import in.hocg.payment.gateway.modules.bmw.mapper.NotifyAppLogMapper;
import in.hocg.payment.gateway.modules.bmw.service.NotifyAppLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * [支付网关] 所有通知应用方日志表 服务实现类
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class NotifyAppLogServiceImpl extends AbstractServiceImpl<NotifyAppLogMapper, NotifyAppLog> implements NotifyAppLogService {

    @Override
    public List<NotifyAppLog> selectListByNotifyAppId(Long notifyId) {
        return lambdaQuery().eq(NotifyAppLog::getNotifyAppId, notifyId).list();
    }
}
