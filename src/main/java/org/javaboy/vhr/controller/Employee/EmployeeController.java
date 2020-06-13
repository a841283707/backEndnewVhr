package org.javaboy.vhr.controller.Employee;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.vo.EmployeeBasicVo;
import org.javaboy.vhr.services.EmployeeServiceImpl;
import org.javaboy.vhr.services.serviceInterface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Api(tags = "员工基本信息的控制器")
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    /*apiParm的value标注右边填入值得解释，左边name标志发送请求的字段名
    * */

    @ApiOperation(value = "得到分页数据")
    @GetMapping("/")
    public EmployeeBasicVo getEmployeeByPage(@ApiParam(name = "page",value = "页码",required = true)
                                                 @RequestParam(value = "page") Integer page,
                                             @ApiParam(name = "size",value = "页码大小",required = true)
                                             @RequestParam(value = "size")Integer size,
                                             @RequestBody Employee employee, @RequestParam(required = false) Date[] beginDateScope){
        EmployeeBasicVo employees=employeeService.getEmpByPage(page,size,employee,beginDateScope);
        return employees;
    }

}
