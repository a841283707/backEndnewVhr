package org.javaboy.vhr.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel(value = "员工基本信息实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "员工性别")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "员工身份证号")
    private String idcard;

    @ApiModelProperty(value = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族ID")
    private Integer nationid;

    @ApiModelProperty(value = "籍贯")
    private String nativeplace;

    @ApiModelProperty(value = "政治面貌ID")
    private Integer politicid;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "部门id")
    private Integer departmentid;

    @ApiModelProperty(value = "职称id")
    private Integer joblevelid;

    @ApiModelProperty(value = "职位ID")
    private Integer posid;

    private String engageform;

    private String tiptopdegree;

    private String specialty;

    private String school;

    private Date begindate;

    private String workstate;

    @ApiModelProperty(value = "工号")
    private String workid;

    private Double contractterm;

    private Date conversiontime;

    private Date notworkdate;

    @ApiModelProperty(value = "开始合同")
    private Date begincontract;

    @ApiModelProperty(value = "结束合同")
    private Date endcontract;

    private Integer workage;

    private Position position;

    private Nation nation;

    private JObLevel jObLevel;

    @ApiModelProperty(value = "部门")
    private Department department;

    @ApiModelProperty(value = "政治面貌")
    private Politicsstatus politicsstatus;

}