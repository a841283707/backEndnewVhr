package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class CustomerAccessDecisionManage implements AccessDecisionManager {
    @Override
/*
    Authentication包括了登录信息，configAttributes是Filter里面返回的需要的安全用户
*/
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            //必须在每一个配置属性类里得到属性方法
            String attribute=configAttribute.getAttribute();
            if (attribute.equals("ROLE_LOGIN")){
                //判断登录信息是否为 弥明用户
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录");
                }else {
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (attribute.equals(authority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");


    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
