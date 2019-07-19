package com.snc.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author Anthony.C
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SncUserRole对象", description="")
@Component
public class SncUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("REL_ID")
    private Long relId;

    @TableField("USER_ID")
    private Long userId;

    @TableField("ROLE_ID")
    private Long roleId;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = " 创建人")
    @TableField("CREATE_USER")
    private Long createUser;

    @ApiModelProperty(value = "更新人")
    @TableField("UPDATE_USER")
    private Long updateUser;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private Long status;


}
