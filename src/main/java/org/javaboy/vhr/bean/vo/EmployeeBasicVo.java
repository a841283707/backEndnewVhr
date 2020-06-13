package org.javaboy.vhr.bean.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javaboy.vhr.bean.Employee;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "基本资料返回的视图对象")
public class EmployeeBasicVo {
    @ApiModelProperty(value = "返回员工的基本资料")
    private List<Employee> employees;

    @ApiModelProperty(value = "返回的总记录条数")
    private Long total;

}
