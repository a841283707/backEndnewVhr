package org.javaboy.vhr.bean;

public class Meta {
    private Boolean keepalive;

    private Boolean requireauth;

    public Meta() {
    }

    public Meta(Boolean keepalive, Boolean requireauth) {
        this.keepalive = keepalive;
        this.requireauth = requireauth;
    }

    public Boolean getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    public Boolean getRequireauth() {
        return requireauth;
    }

    public void setRequireauth(Boolean requireauth) {
        this.requireauth = requireauth;
    }
}
