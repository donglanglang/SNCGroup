package com.snc.main.controller;

import com.snc.shiro.entity.SncUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Package com.snc.main.controller
 * @Description: (用一句话描述该文件做什么)
 * @Author Anthony.C
 * @date Created in 下午8:35 2019/7/17
 */
@Slf4j
@Controller
public class TestController {

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @PostMapping(value = "/user_login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            //完成登录
            subject.login(usernamePasswordToken);
            SncUser user = (SncUser)subject.getPrincipal();
            session.setAttribute("user",user);
            return "redirect:/index";
        } catch (Exception e) {
            String ex = e.getClass().getName();
            if (ex != null) {
                if (UnknownAccountException.class.getName().equals(ex)) {
                    System.out.println("用户名不存在");
                } else if (IncorrectCredentialsException.class.getName().equals(ex)) {
                    System.out.println("账户或密码错误");
                } else {
                    System.out.println("未知错误");
                }
            }
            //返回登录页面
            return "login";
        }
    }

    @ResponseBody
    @GetMapping(value = "/index")
    public String index(){
        return "welcome";
    }


    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }



    //未授权mapping配置
    @ResponseBody
    @GetMapping(value = "/403")
    public String error(){
        return "没有权限!";
    }


    //注解的使用
    //管理员角色
    @ResponseBody
    @RequiresRoles("admin")
    @RequestMapping(value = "/role/admin")
    public String roleAdmin(){
        return "I am admin";
    }

    //普通用户角色
    @ResponseBody
    @RequiresRoles("common")
    @RequestMapping(value = "/role/common")
    public String roleCommon(){
        return "I am common";
    }

    //拥有添加、删除权限
    @ResponseBody
    @RequiresPermissions({"add","delete"})
    @RequestMapping(value = "/permissions")
    public String Permissions(){
        return "I have permissions add and delete";
    }

    //只拥有添加权限
    @ResponseBody
    @RequiresPermissions("add")
    @RequestMapping(value = "/permission/add")
    public String Permission(){
        return "I have permission add";
    }

}
