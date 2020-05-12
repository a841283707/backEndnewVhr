package org.javaboy.vhr.services;

import org.javaboy.vhr.bean.JObLevel;
import org.javaboy.vhr.mapper.JObLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelService {
    @Autowired
     private  JObLevelMapper jObLevelMapper;

    public  List<JObLevel> getGrades() {
            return jObLevelMapper.getGrades();
    }

    public Integer addGrade(JObLevel jObLevel) {
        return jObLevelMapper.addGrade(jObLevel);
    }

    public Integer deleteGrade(Integer id) {
        return jObLevelMapper.deleteGrade(id);
    }

    public Integer updateGrade(JObLevel jObLevel) {
            return jObLevelMapper.updateGrade(jObLevel);
    }
}
