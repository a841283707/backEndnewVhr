package org.javaboy.vhr.services;

import org.javaboy.vhr.bean.Menu;
import org.javaboy.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;


    public List<Menu> getMenuById(Integer hrid){
        return menuMapper.getMenuById(hrid);
    }

    public List<Menu> getMenuWithRoles() {
        //得到数据库里带有角色信息的menu
        return  menuMapper.getMenuWithRoles();
    }
}
