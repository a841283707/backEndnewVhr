package org.javaboy.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.javaboy.vhr.bean.Nation;

public interface NationMapper extends BaseMapper<Nation> {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);
}