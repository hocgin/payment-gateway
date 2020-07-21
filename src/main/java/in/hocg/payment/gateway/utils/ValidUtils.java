package in.hocg.payment.gateway.utils;

import in.hocg.payment.gateway.basic.exception.ServiceException;
import in.hocg.payment.gateway.basic.result.ResultCode;
import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

/**
 * Created by hocgin on 2020/2/15.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@UtilityClass
public class ValidUtils {
    
    public void notNull(Object object, String message) {
        try {
            Assert.notNull(object, message);
        } catch (Exception e) {
            throw ServiceException.wrap(e.getMessage());
        }
    }
    
    public void notNull(Object object) {
        notNull(object, ResultCode.SERVICE_ERROR.getMessage());
    }
    
    public void isNull(Object object, String message) {
        try {
            Assert.isNull(object, message);
        } catch (Exception e) {
            throw ServiceException.wrap(e.getMessage());
        }
    }
    
    public void isNull(Object object) {
        isNull(object, ResultCode.SERVICE_ERROR.getMessage());
    }
    
    public void isTrue(boolean expression, String message) {
        try {
            Assert.isTrue(expression, message);
        } catch (Exception e) {
            throw ServiceException.wrap(e.getMessage());
        }
    }
    
    public void isTrue(boolean expression) {
        isTrue(expression, ResultCode.SERVICE_ERROR.getMessage());
    }
    
    public void isFalse(boolean expression, String message) {
        try {
            Assert.isTrue(!expression, message);
        } catch (Exception e) {
            throw ServiceException.wrap(e.getMessage());
        }
    }
    
    public void isFalse(boolean expression) {
        isFalse(expression, ResultCode.SERVICE_ERROR.getMessage());
    }
    
    public void fail(String message) {
        throw ServiceException.wrap(LangUtils.getOrDefault(message, ResultCode.SERVICE_ERROR.getMessage()));
    }
    
    public void fail(Exception e) {
        fail(e.getMessage());
    }
    
}
