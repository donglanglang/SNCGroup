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
@ApiModel(value="SncUser对象", description="")
@Component
public class SncUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId("USER_ID")
    private Long userId;

    @ApiModelProperty(value = "用户姓名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "用户账号")
    @TableField("USER_CODE")
    private String userCode;

    @ApiModelProperty(value = "密码")
    @TableField("PASS_WORD")
    private String passWord;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private Long status;

    @ApiModelProperty(value = "电话")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "邮件")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "备用字段")
    @TableField("FLAG")
    private Long flag;

    @ApiModelProperty(value = "1:男；2:女")
    @TableField("SEX")
    private Long sex;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATE_USER")
    private Long createUser;

    @ApiModelProperty(value = "更新人")
    @TableField("UPDATE_USER")
    private Long updateUser;

    @ApiModelProperty(value = "加密")
    @TableField("SALT")
    private String salt;

}
