package com.jk.model;

public class YhModel {
    private Integer usid;

    private String usname;

    private String ustype;

    private String uspwd;

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname == null ? null : usname.trim();
    }

    public String getUstype() {
        return ustype;
    }

    public void setUstype(String ustype) {
        this.ustype = ustype == null ? null : ustype.trim();
    }

    public String getUspwd() {
        return uspwd;
    }

    public void setUspwd(String uspwd) {
        this.uspwd = uspwd == null ? null : uspwd.trim();
    }
}