package org.javaboy.vhr.mapper;

import org.javaboy.vhr.bean.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> getMenuById(Integer hrid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);


    List<Menu> getMenuWithRoles();
}