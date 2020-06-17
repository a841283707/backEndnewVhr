package org.javaboy.vhr.services.serviceInterface;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.vo.EmployeeBasicVo;

import java.util.Date;
import java.util.List;

/**
 * 继承IService类，这个类的实现类是ServiceImpl
 * */
public interface EmployeeService extends IService<Employee> {
    EmployeeBasicVo getEmpByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope);

    Boolean batchInsert(List<Employee> employees);
}
