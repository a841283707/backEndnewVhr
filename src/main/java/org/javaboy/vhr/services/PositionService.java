package org.javaboy.vhr.services;

import org.javaboy.vhr.bean.Position;
import org.javaboy.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;
    public List<Position> getAllPosition(){
        return positionMapper.getAllPosition();
    }

    public void addPosition(String name) {
            positionMapper.addPosition(name);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deletePosition(id);
    }
}
