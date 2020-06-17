package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getDepartmentByParentId(Integer id);

    List<Department> getAllDepartmentsWithOutChildren();

    List<String> getName();

    List<Department> getTest();

    void insertDepartment(Department department);

    String getDeppath(Integer parentId);

    void insertPath(@Param(value = "path") String path,@Param(value = "id") Integer id);

    Boolean getIsParent(Integer parentId);

    void updateIsParentId(Integer parentId);

    Integer getCountInemp(Integer id);

    Integer getparentId(Integer id);

    Integer getCountChild(Integer parentId);

    void updateIsParentById(Integer parentId);

    void deleteDep(Integer id);
}