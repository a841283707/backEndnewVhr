package org.javaboy.vhr.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Position {
    private Integer id;

    private String name;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdate;

    private Boolean enabled;

    public Position() {
    }

    public Position(Integer id, String name, Date createdate, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.createdate = createdate;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdate=" + createdate +
                ", enabled=" + enabled +
                '}';
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