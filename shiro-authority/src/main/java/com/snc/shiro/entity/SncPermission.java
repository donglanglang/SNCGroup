package com.snc.shiro.entity;

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
@ApiModel(value="SncPermission对象", description="")
@Component
public class SncPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("PERMISSION_ID")
    private Long permissionId;

    @ApiModelProperty(value = "权限编码")
    @TableField("PERMISSION_CODE")
    private String permissionCode;

    @ApiModelProperty(value = "权限名称")
    @TableField("PERMISSION_NAME")
    private String permissionName;

    @TableField("URL")
    private String url;


}
