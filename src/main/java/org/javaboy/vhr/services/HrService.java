package org.javaboy.vhr.services;

import org.javaboy.vhr.mapper.HrMapper;
import org.javaboy.vhr.bean.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Override
    public Hr loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr=hrMapper.loadUserByUsername(username);
        if (hr==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRoleById(hr.getId()));
        return hr;
    }

    public void updatePassword(Hr hrByuserName) {
        hrMapper.updatePasswordByUserName(hrByuserName);
    }
}
