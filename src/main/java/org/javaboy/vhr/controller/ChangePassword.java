package org.javaboy.vhr.controller;

import io.swagger.annotations.Api;
import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.services.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = "修改密码")
@RestController
@RequestMapping("/change")
public class ChangePassword {
    @Autowired
    private HrService hrService;

    @RequestMapping("/updatePassword")
    public String updatePassword(HttpServletRequest request, @RequestParam String password,@RequestParam String newpwd) {
        //获取session
        HttpSession session = request.getSession();
        //获取session域的用户名
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Hr user = (Hr) authentication.getPrincipal();
        System.out.println(user);
        String username = user.getUsername();
        //获取用户输入的原密码
        String resetForm = request.getParameter("resetForm");
        //用户输入的新密码
//        String newPassword = request.getParameter("newPassword");
        //根据名字获得用户
        Hr hrByuserName = hrService.loadUserByUsername(username);
        //获得用户加密后的原密码
        String password2 = hrByuserName.getPassword();
        //判断输入的原密码和加密后的密码是否一致
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean matches = bc.matches(password,password2 );
        if (matches) {
            hrByuserName.setPassword(bc.encode(newpwd));
            //如果输入原密码正确就修改密码
            hrService.updatePassword(hrByuserName);
//            sysUserService.updatePassword(sysUser);
//            session.setAttribute("result","true");
//            return "main";
        } else {
            //如果不存在提示密码不正确
//            session.setAttribute("result","false");
        }
        return "update-password";
    }
   /* @RequestMapping("/updatePassword")
    public String updatePassword(HttpServletRequest request) {
        //获取session
        HttpSession session = request.getSession();
        //获取session域的用户名
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        String username = user.getUsername();
        //获取用户输入的原密码
        String password = request.getParameter("password");
        //用户输入的新密码
        String newPassword = request.getParameter("newPassword");
        //根据名字获得用户
        SysUser sysUser = sysUserService.findByName(username);
        //获得用户加密后的原密码
        String password2 = sysUser.getPassword();
        //判断输入的原密码和加密后的密码是否一致
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean matches = bc.matches(password,password2 );
        if (matches) {
            sysUser.setPassword(passwordEncoder.encode(newPassword));
            //如果输入原密码正确就修改密码
            sysUserService.updatePassword(sysUser);
            session.setAttribute("result","true");
            return "main";
        } else {
            //如果不存在提示密码不正确
            session.setAttribute("result","false");
        }
        return "update-password";
    }*/
}
