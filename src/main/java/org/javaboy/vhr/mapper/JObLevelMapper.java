package org.javaboy.vhr.mapper;

import org.javaboy.vhr.bean.JObLevel;

import java.util.List;

public interface JObLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JObLevel record);

    int insertSelective(JObLevel record);

    JObLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JObLevel record);

    int updateByPrimaryKey(JObLevel record);

    List<JObLevel> getGrades();

    Integer addGrade(JObLevel jObLevel);

    Integer deleteGrade(Integer id);

    Integer updateGrade(JObLevel jObLevel);
}