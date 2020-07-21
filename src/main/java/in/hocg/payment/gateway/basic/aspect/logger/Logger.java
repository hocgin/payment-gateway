package in.hocg.payment.gateway.basic.aspect.logger;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import in.hocg.payment.gateway.basic.ext.web.SpringContext;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created by hocgin on 2020/3/3.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Accessors(chain = true)
public class Logger {
    @ApiModelProperty("代码位置")
    private String mapping;
    @ApiModelProperty("来源(需使用请求参数, 如: source=eagle)")
    private String source;
    @ApiModelProperty("请求头:host")
    private String host;
    @ApiModelProperty("请求头:user-agent")
    private String userAgent;
    @ApiModelProperty("请求IP")
    private String clientIp;
    @ApiModelProperty("入口描述")
    private String enterRemark;
    @ApiModelProperty("请求方式")
    private String method;
    @ApiModelProperty("请求URL")
    private String uri;
    @ApiModelProperty("请求参数")
    private List<Object> args;
    @ApiModelProperty("响应")
    private Object ret;
    @ApiModelProperty("异常信息")
    private String exception;
    @ApiModelProperty("请求耗时")
    private Long totalTimeMillis;
    @ApiModelProperty("发起请求的时间")
    private LocalDateTime createdAt;
    @ApiModelProperty("线程内日志")
    private static final ThreadLocal<List<String>> LOGS_REMARK = new ThreadLocal<>();
    
    
    public static void log(String message) {
        getOrCreateLogPool().add(message);
    }
    
    private static List<String> getOrCreateLogPool() {
        List<String> list = LOGS_REMARK.get();
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
            LOGS_REMARK.set(list);
        }
        return list;
    }
    
    public void save() {
        SpringContext.getBean(LoggerService.class).handle(this);
    }
    
    public String getArgsStr() {
        return JSONUtil.toJsonPrettyStr(args);
    }
    
    public String getRetStr() {
        String retStr;
        if ((ret instanceof InputStream) || (ret instanceof OutputStream)) {
            retStr = "[\"File Stream\"]";
        } else if (ret instanceof ResponseEntity && ((ResponseEntity) ret).getBody() instanceof Resource) {
            retStr = "[\"Resource Stream\"]";
        } else {
            retStr = JSONUtil.toJsonPrettyStr(ret);
        }
        return retStr;
    }
}
