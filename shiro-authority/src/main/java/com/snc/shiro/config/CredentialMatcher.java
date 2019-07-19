package com.snc.shiro.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @version V1.0
 * @Package com.snc.shiro.config
 * @Description: (自定义密码校验)
 * @Author Anthony.C
 * @date Created in 上午11:00 2019/7/19
 */
public class CredentialMatcher extends SimpleCredentialsMatcher{
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        //目前只比较数据库密码和token里的密码是否一致
        String password = new String(usernamePasswordToken.getPassword());
        String dbPassword = (String)info.getCredentials();
        return this.equals(password,dbPassword);
    }
}
