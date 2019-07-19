package com.snc.shiro.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * @version V1.0
 * @Package com.snc.shiro.entity
 * @Description: (用户对象类)
 * @Author Anthony.C
 * @date Created in 下午4:25 2019/7/19
 */
@Getter
@Setter
public class SncUserInfo {

    private Long userId;

    private String userName;

    private String userCode;

    private String passWord;

    private Long status;

    private String phone;

    private String email;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long flag;

    private Long sex;

    private Long createUser;

    private Long updateUser;

    private String salt;

    private String credentialsSalt;

    private SncUserInfo entityToInfo(SncUser sncUser){
        SncUserInfo userInfo = new SncUserInfo();
        BeanUtils.copyProperties(sncUser, userInfo);
        userInfo.setCredentialsSalt(sncUser.getUserName()+sncUser.getSalt());
        return userInfo;
    }

}
