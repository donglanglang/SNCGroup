package com.snc.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snc.shiro.entity.SncPermission;
import com.snc.shiro.entity.SncRole;
import com.snc.shiro.entity.SncUser;
import com.snc.shiro.entity.SncUserRole;
import com.snc.shiro.mapper.SncRoleMapper;
import com.snc.shiro.mapper.SncUserRoleMapper;
import com.snc.shiro.service.ISncUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version V1.0
 * @Package com.snc.shiro.config
 * @Description: (ShiroRealm)
 * @Author Anthony.C
 * @date Created in 下午8:19 2019/7/17
 */
@Slf4j
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISncUserService sncUserService;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        log.info("==============="+principalCollection.getPrimaryPrincipal());
        SncUser user = (SncUser) principalCollection.getPrimaryPrincipal();

        log.info("===============用户ID："+user.getUserId()+"，用户名称："+user.getUserName());

        //查询对应角色
        Set<String> allRoles = new HashSet<String>(sncUserService.findRoleByUser(user.getUserId()));
        Set<String> allPermissions = new HashSet<String>(sncUserService.findPermissionByUser(user.getUserId()));
        //添加角色
        simpleAuthorizationInfo.addRoles(allRoles);
        simpleAuthorizationInfo.addStringPermissions(allPermissions);

        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1、登录认证的方法需要先执行，需要用他来判断登录的用户信息是否合法
        String username = (String) token.getPrincipal();    // 取得用户名
        // 需要通过用户名取得用户的完整信息，利用业务层操作
        SncUser user = null;
        try {
            user = sncUserService.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException("该用户名称不存在！");
        } else {    // 进行密码的验证处理
            String password =new String((char[]) token.getCredentials());
            // 将数据库中的密码与输入的密码进行比较，这样就可以确定当前用户是否可以正常登录
            if (user.getPassWord().equals(password)) {    // 密码正确

                AuthenticationInfo auth = new SimpleAuthenticationInfo(user, password, "memberRealm");
                return auth;
            } else {
                throw new IncorrectCredentialsException("密码错误！");
            }
        }
    }
}
