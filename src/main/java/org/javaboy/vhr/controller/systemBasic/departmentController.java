package org.javaboy.vhr.controller.systemBasic;


import org.javaboy.vhr.bean.Department;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/basic/department")
public class departmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getDepartmentByParentId(){
        return departmentService.getDepartmentByParentId(-1);
    }

    @GetMapping("/getName")
    public List<String> getName(){
        return departmentService.getName();
    }

    @GetMapping("/getDepartment")
    public List<Department> test(){
        return departmentService.getTest();
    }

    @PostMapping("/insertDepartment")
    /*postman发送带contentType的请求时，在header里面设置contentType
    在Body raw数据里面设置数据*/
    public void insertDepartment(@RequestBody Department department){
        departmentService.insertDepartment(department);
        Integer id=department.getId();
        Integer parentId=department.getParentid();
        Boolean b=departmentService.getIsParent(parentId);
        if (!b){
            departmentService.updateIsParent(parentId);
        }
        String path=departmentService.getDeppath(parentId,id);
        departmentService.insertPath(path,id);

    }

    @PostMapping("/deleteDep")
    public RespBean deleteDep(@RequestParam Integer id, @RequestParam Boolean isParent){
        if (!isParent){
            if (departmentService.getCountInEmp(id)>0){
                return RespBean.error("部门存有员工删除失败");
            }else {
                Integer parentId= departmentService.getparentId(id);
                if (departmentService.getCountChild(parentId)==1){
                    departmentService.updateIsParentById(parentId);
                    departmentService.deleteDep(id);
                    return RespBean.ok("删除成功");
                }else {
                    departmentService.deleteDep(id);
                    return RespBean.ok("删除成功");
                }
            }
        }
        return null;
    }
}
