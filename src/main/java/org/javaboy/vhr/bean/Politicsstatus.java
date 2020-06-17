package org.javaboy.vhr.bean;

public class Politicsstatus {
    private Integer id;

    public Politicsstatus(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null || getClass()!=obj.getClass()){
            return false;
        }
        Politicsstatus politicsstatus=(Politicsstatus) obj;
        return (this.name.equals(politicsstatus.name));
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