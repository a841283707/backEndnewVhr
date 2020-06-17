package org.javaboy.vhr.bean;

import org.apache.poi.ss.formula.functions.Na;

public class Nation {
    private Integer id;

    public Nation(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null || getClass()!=obj.getClass()){
            return false;
        }
        Nation nation=(Nation)obj;
        return (this.name.equals(nation.name));
    }

    private String name;

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
        this.name = name == null ? null : name.trim();
    }
}