package org.javaboy.vhr.bean;

import java.util.List;

public class Menu {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconcls;

    private Meta meta;

    private Integer parentid;

    private Boolean enabled;

    private List<Menu> children;

    private List<Role> roles;

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Menu(Integer id, String url, String path, String component, String name, String iconcls, Meta meta, Integer parentid, Boolean enabled, List<Menu> children, List<Role> roles) {
        this.id = id;
        this.url = url;
        this.path = path;
        this.component = component;
        this.name = name;
        this.iconcls = iconcls;
        this.meta = meta;
        this.parentid = parentid;
        this.enabled = enabled;
        this.children = children;
        this.roles = roles;
    }
}