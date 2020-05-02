package org.javaboy.vhr.services;

import org.javaboy.vhr.bean.Department;
import org.javaboy.vhr.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDepartmentByParentId(Integer id){
        return departmentMapper.getDepartmentByParentId(id);
    }

    public List<String> getName() {
        return departmentMapper.getName();
    }

    public List<Department> getTest() {
        return departmentMapper.getTest();
    }

    public void insertDepartment(Department department) {
            departmentMapper.insertDepartment(department);
    }


    public String getDeppath(Integer parentId,Integer id) {
        String parentPath=departmentMapper.getDeppath(parentId);
        /*departmentMapper.getDeppath(id)
        return ;*/
        return parentPath+'.'+id;
    }

    public void insertPath(String path, Integer id) {
        departmentMapper.insertPath(path,id);
    }

    public Boolean getIsParent(Integer parentId) {
        return departmentMapper.getIsParent(parentId);
    }

    public void updateIsParent(Integer parentId) {
        departmentMapper.updateIsParentId(parentId);
    }

    public void deleteDep(Integer id) {
        departmentMapper.deleteDep(id);
    }

    public Integer getCountInEmp(Integer id) {
        return departmentMapper.getCountInemp(id);
    }

    public Integer getparentId(Integer id) {
        return  departmentMapper.getparentId(id);
    }

    public Integer getCountChild(Integer parentId) {
        return departmentMapper.getCountChild(parentId);
    }

    public void updateIsParentById(Integer parentId) {
         departmentMapper.updateIsParentById(parentId);
    }
}
