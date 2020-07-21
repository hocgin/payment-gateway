package in.hocg.payment.gateway.basic.aspect.logger;

import in.hocg.payment.gateway.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * Created by hocgin on 2020/2/28.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
public class DefaultLoggerService implements LoggerService {
    
    @Override
    public void handle(Logger logger) {
        printlnPrettyLogger(logger);
    }
    
    private void printlnPrettyLogger(Logger logger) {
        StringJoiner stringJoiner = new StringJoiner("\n")
                .add("")
                .add("╔═[{}]═{}════════════════════════════════════════════════")
                .add("║ {}")
                .add("║ > {} ({})")
                .add("╠═[请求体]════════════════════════════════════════════════════════════════════════════")
                .add("║ {}")
                .add("╠═[响应体]════════════════════════════════════════════════════════════════════════════")
                .add("║ {}")
                .add("╚═[总耗时:{} ms]══════════════════════════════════════════════════════════════════════")
                .add("");
        final String retStr = logger.getRetStr();
        final String argStr = logger.getArgsStr();
        
        
        log.info(stringJoiner.toString(),
                DateUtils.format(LocalDateTime.now(), DateUtils.SIMPLE_FORMATTER),
                getUserStringThrow(),
                String.format("%s %s", logger.getMethod(), logger.getUri()),
                logger.getEnterRemark(),
                logger.getMapping(),
                argStr.replaceAll("\n", "\n║ "),
                retStr.replaceAll("\n", "\n║ "),
                logger.getTotalTimeMillis());
    }
    
    private String getUserStringThrow() {
        try {
            return "未登录";
        } catch (Exception e) {
            log.error("", e);
            return "数据异常";
        }
    }
}
