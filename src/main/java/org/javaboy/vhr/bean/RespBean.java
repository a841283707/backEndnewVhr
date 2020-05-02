package org.javaboy.vhr.bean;

public class RespBean {
    private Integer status;

    private String msg;

    private Object object;

    public static RespBean ok(String s){
        return new RespBean(200,s,null);

    }

    public static RespBean ok(String s,Object o){
        return new RespBean(200,s,o);

    }

    public static RespBean error(String s){
        return new RespBean(500,s,null);

    }

    public static RespBean error(String s,Object o){
        return new RespBean(500,s,o);

    }

    public RespBean() {
    }

    public RespBean(Integer status, String msg, Object object) {
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
