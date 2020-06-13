package org.javaboy.vhr.controller.Employee;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.javaboy.vhr.bean.*;
import org.javaboy.vhr.bean.vo.EmployeeBasicVo;
import org.javaboy.vhr.services.*;
import org.javaboy.vhr.services.serviceInterface.EmployeeService;
import org.javaboy.vhr.services.serviceInterface.NationService;
import org.javaboy.vhr.services.serviceInterface.PoliticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Api(tags = "员工基本信息的控制器")
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {


    private EmployeeService employeeService;

    private NationService nationService;

    private PoliticService politicService;

    private PositionService positionService;

    private JobLevelService jobLevelService;

    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, NationService nationService, PoliticService politicService, PositionService positionService, JobLevelService jobLevelService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.nationService = nationService;
        this.politicService = politicService;
        this.positionService = positionService;
        this.jobLevelService = jobLevelService;
        this.departmentService = departmentService;
    }
    /*apiParm的value标注右边填入值得解释，左边name标志发送请求的字段名
    * */

    @ApiOperation(value = "得到分页数据")
    @PostMapping("/")
    public EmployeeBasicVo getEmployeeByPage(@ApiParam(name = "page",value = "页码",required = true)
                                                 @RequestParam(value = "page") Integer page,
                                             @ApiParam(name = "size",value = "页码大小",required = true)
                                             @RequestParam(value = "size")Integer size,
                                             @RequestBody(required = false) Employee employee, @RequestParam(required = false) Date[] beginDateScope){
        EmployeeBasicVo employees=employeeService.getEmpByPage(page,size,employee,beginDateScope);
        return employees;
    }

    @ApiOperation(value = "得到所有的政治身份选项")
    @GetMapping("/getPolitic")
    public List<Politicsstatus> getPolitic(){
        return politicService.getPoliticStatus();
    }

    @ApiOperation(value = "得到所有的职位选项")
    @GetMapping("/getPosition")
    public List<Position> getPosition(){
        return positionService.getAllPosition();
    }

    @ApiOperation(value = "得到所有的职称选项")
    @GetMapping("/getJobLevel")
    public List<JObLevel> getJobLevel(){
        return jobLevelService.getGrades();
    }

    @ApiOperation(value = "得到所有的民族选项")
    @GetMapping("/getNation")
    public List<Nation> getNation(){
        return nationService.getNation();
    }
//
//    @ApiOperation(value = "得到所有的民族选项")
//    @GetMapping("/getNation")
//    public List<Nation> getNation(){
//        return nationService.getNation();
//    }

}
