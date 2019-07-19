package com.snc.shiro.service;

import com.snc.shiro.entity.SncUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Anthony.C
 * @since 2019-07-18
 */
public interface ISncUserService extends IService<SncUser> {

    List<String> findRoleByUser(Long userId);

    List<String> findPermissionByUser(Long userId);

    SncUser findByUserName(String userName);
}
