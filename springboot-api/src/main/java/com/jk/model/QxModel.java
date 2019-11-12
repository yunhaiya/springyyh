package com.jk.model;

import java.io.Serializable;

public class QxModel implements Serializable {

    private static final long serialVersionUID = 8506191501202450805L;

    private String qxid;

    private String qxname;


    //Integer--》String

    public String getQxid() {
        return qxid;
    }

    public void setQxid(String qxid) {
        this.qxid = qxid;
    }

    public String getQxname() {
        return qxname;
    }

    public void setQxname(String qxname) {
        this.qxname = qxname == null ? null : qxname.trim();
    }
}