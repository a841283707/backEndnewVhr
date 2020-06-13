package org.javaboy.vhr.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.vo.EmployeeBasicVo;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.services.serviceInterface.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * ServiceImpl里面有EmployeeMapper作为BaseMapper,
 * 因此可以在实现类里面调用this.baseMapper调用父类的protect域里面的baseMapper(EmployeeMapper)
 * EmployeeMapper必须继承BaseMapper<>,ServiceImpl实现了EmployeeService里面的IService接口
 * */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public EmployeeBasicVo getEmpByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        Page<Employee> page1=new Page<>(page,size);
        IPage<Employee> employeeIPage = this.baseMapper.selectPageVo(page1, employee, beginDateScope);
        long total = employeeIPage.getTotal();
        List<Employee> records = employeeIPage.getRecords();
        return new EmployeeBasicVo(records,total);
    }
}
