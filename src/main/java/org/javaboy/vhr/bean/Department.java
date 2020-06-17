package org.javaboy.vhr.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Department {
    private Integer id;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null || getClass()!=obj.getClass()){
            return false;
        }
        Department department=(Department)obj;
        return (this.name.equals(department.name));
    }


    @JsonProperty(value = "departmentName")
    private String name;

    @JsonProperty(value = "departmentId")
    private Integer parentid;

    private String deppath;

    private Boolean enabled;

    private Boolean isparent;

    private List<Department> children;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIsparent() {
        return isparent;
    }

    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public Department(Integer id, String name, Integer parentid, String deppath, Boolean enabled, Boolean isparent, List<Department> children) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
        this.deppath = deppath;
        this.enabled = enabled;
        this.isparent = isparent;
        this.children = children;
    }
}