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
 * 角色表
 * </p>
 *
 * @author Anthony.C
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SncRole对象", description="角色表")
@Component
public class SncRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    @TableId("ROLE_ID")
    private Long roleId;

    @ApiModelProperty(value = "角色编码")
    @TableField("ROLE_CODE")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    @TableField("ROLE_NAME")
    private String roleName;

    @ApiModelProperty(value = "描述")
    @TableField("ROLE_DESCRIPTION")
    private String roleDescription;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人ID")
    @TableField("CREATE_USER")
    private Long createUser;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人")
    @TableField("UPDATE_USER")
    private Long updateUser;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private Long status;

    @ApiModelProperty(value = "备用字段")
    @TableField("FLAG")
    private Long flag;


}
