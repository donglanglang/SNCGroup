package com.snc.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="SncRolePermission对象", description="")
@Component
public class SncRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("REL_ID")
    private Long relId;

    @ApiModelProperty(value = "角色ID")
    @TableField("ROLE_ID")
    private Long roleId;

    @ApiModelProperty(value = "权限ID")
    @TableField("PERMISSION_ID")
    private Long permissionId;

    @ApiModelProperty(value = " 状态")
    @TableField("STATUS")
    private Long status;


}
