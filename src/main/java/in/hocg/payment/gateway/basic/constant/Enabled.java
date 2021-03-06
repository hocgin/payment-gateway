package in.hocg.payment.gateway.basic.constant;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by hocgin on 2020/2/11.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Getter
@ApiModel("启用状态")
@RequiredArgsConstructor
public enum Enabled implements DataDictEnum {
    Off(0, "禁用"),
    On(1, "启用");
    private final Integer code;
    private final String name;

    public static final String KEY = "enabled";

    public static Enabled valueOf(boolean enabled) {
        return enabled ? Enabled.On : Enabled.Off;
    }
}
