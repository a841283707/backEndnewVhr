package org.javaboy.vhr.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class JObLevel {
    private Integer id;

    private String name;

    public JObLevel(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null || getClass()!=obj.getClass()){
            return false;
        }
        JObLevel jObLevel=(JObLevel) obj;
        return (this.name.equals(jObLevel.name));
    }


    private String titlelevel;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    private Boolean enabled;

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

    public String getTitlelevel() {
        return titlelevel;
    }

    public void setTitlelevel(String titlelevel) {
        this.titlelevel = titlelevel == null ? null : titlelevel.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}