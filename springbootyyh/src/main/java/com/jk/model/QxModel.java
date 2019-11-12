package com.jk.model;

public class QxModel {
    private Integer qxid;

    private String qxname;



    public Integer getQxid() {
        return qxid;
    }

    public void setQxid(Integer qxid) {
        this.qxid = qxid;
    }

    public String getQxname() {
        return qxname;
    }

    public void setQxname(String qxname) {
        this.qxname = qxname == null ? null : qxname.trim();
    }
}