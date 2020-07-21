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
 * [支付网关] 支付渠道规则表
 * </p>
 *
 * @author hocgin
 * @since 2020-07-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("bmw_payment_way_rule")
public class PaymentWayRule extends AbstractEntity<PaymentWayRule> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("接入方应用")
    @TableField("app_id")
    private Long appId;
    @ApiModelProperty("规则名称")
    @TableField("title")
    private String title;
    @ApiModelProperty("场景码")
    @TableField("scene_code")
    private String sceneCode;
    @ApiModelProperty("启用状态[0:为禁用状态;1:为正常状态]")
    @TableField("enabled")
    private Integer enabled;
    @TableField("created_at")
    private LocalDateTime createdAt;
    @TableField("updated_at")
    private LocalDateTime updatedAt;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
