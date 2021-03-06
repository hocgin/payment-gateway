package in.hocg.payment.gateway.basic.env;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2020/4/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Component
@ConfigurationProperties(prefix = EnvConfigs.PREFIX)
public class EnvConfigs {
    public static final String PREFIX = "app";
    @ApiModelProperty("服务域名")
    private String hostname = "http://127.0.0.1:8080";
    
    @ApiModelProperty("微信 APP ID")
    private String wxAppId;
    @ApiModelProperty("微信 KEY")
    private String wxKey;
    @ApiModelProperty("微信商户号")
    private String wxMchId;
    @ApiModelProperty("微信证书绝对路径")
    private String wxCertFile;
    
    @ApiModelProperty("支付宝 公钥")
    private String aliPayPublicKey;
    @ApiModelProperty("支付宝 私钥")
    private String aliPayPrivateKey;
    @ApiModelProperty("支付宝 APPID")
    private String aliPayAppId;
    
    @ApiModelProperty("支付接入应用")
    private Long paymentAppSn = 1L;
    
}
