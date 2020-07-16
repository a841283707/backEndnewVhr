package org.javaboy.vhr.mapper;

import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRoleById(Integer id);

    void updatePasswordByUserName(Hr hrByuserName);
}