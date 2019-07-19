package com.snc.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;


/**
 * @version V1.0
 * @Package com.snc.shiro.config
 * @Description: (权限配置类)
 * @Author Anthony.C
 * @date Created in 下午8:13 2019/7/17
 */
@Slf4j
@Configuration
public class ShiroConfig {

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 权限控制map.
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();

        filterChainDefinitionMap.put("/static/**", "anon");// 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/logout*","logout");
        filterChainDefinitionMap.put("/css/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/js/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/img/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/font/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/images/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/login", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/user_login", "anon");
        filterChainDefinitionMap.put("/error","anon");
        filterChainDefinitionMap.put("/**","authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    //将自己的验证方式加入容器
    @Bean("shiroRealm")
    public ShiroRealm shiroRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher) {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(matcher);
        return shiroRealm;
    }

    //将自定义密码校验加入容器
    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher(){
        return new CredentialMatcher();
    }



    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);//默认fasle
        return defaultAdvisorAutoProxyCreator;
    }

}
