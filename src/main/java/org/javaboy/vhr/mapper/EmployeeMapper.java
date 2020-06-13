package org.javaboy.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.bean.Employee;

import java.util.Date;

public interface EmployeeMapper extends BaseMapper<Employee> {
    int deleteByPrimaryKey(Integer id);

//    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    IPage<Employee> selectPageVo(Page<?> page,  Employee emp, Date[] beginDateScope);
}