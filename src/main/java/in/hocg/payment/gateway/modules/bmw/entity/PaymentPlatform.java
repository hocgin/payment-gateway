package in.hocg.payment.gateway.modules.bmw.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.payment.gateway.basic.ext.mybatis.core.AbstractEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * [支付网关] 支付平台表
 * </p>
 *
 * @author hocgin
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("bmw_payment_platform")
public class PaymentPlatform extends AbstractEntity<PaymentPlatform> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("支付平台的唯一标识")
    @TableField("platform_appid")
    private String platformAppid;
    @ApiModelProperty("标题")
    @TableField("title")
    private String title;
    @ApiModelProperty("支付平台类型: 0=>AliPay; 1=>WxPay")
    @TableField("platform_type")
    private Integer platformType;
    @ApiModelProperty("启用状态[0:为禁用状态;1:为正常状态]")
    @TableField("enabled")
    private Integer enabled;
    @ApiModelProperty("创建时间")
    @TableField("created_at")
    private LocalDateTime createdAt;
    @ApiModelProperty("创建ip")
    @TableField("created_ip")
    private String createdIp;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
