package org.javaboy.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.javaboy.vhr.bean.Politicsstatus;

public interface PoliticsstatusMapper extends BaseMapper<Politicsstatus> {
    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);
}