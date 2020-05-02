package org.javaboy.vhr.config;

import org.javaboy.vhr.bean.Menu;
import org.javaboy.vhr.bean.Role;
import org.javaboy.vhr.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.security.Security;
import java.util.Collection;
import java.util.List;



//得到需要的角色,invocation：调用
@Component
public class CustomerFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    //按照规则匹配url的一个工具类
    AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //得到请求的url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //得到所有带有roles的menu
        List<Menu> menus= menuService.getMenuWithRoles();

        for (Menu menu : menus) {
            //匹配到url的话就把roles里面的name保存在一个数组
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles=menu.getRoles();
                String[] roleNames=new String[roles.size()];
                /*roles.fori*/
                for (int i = 0; i < roles.size(); i++) {
                    //roles.get[i]
                    roleNames[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(roleNames);
            }

        }
        //没有定位到的返回“Role_LOGIN”,标记,用于在decide中做判断，抛出异常
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
