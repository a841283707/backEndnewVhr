package org.javaboy.vhr.mapper;

import org.javaboy.vhr.bean.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPosition();

    void addPosition(String name);

    Integer updatePosition(Position position);

    Integer deletePosition(Integer id);
}