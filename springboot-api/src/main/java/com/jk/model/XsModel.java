package com.jk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class XsModel implements Serializable {


    private Integer xid;

    private String xname;

    private String xtype;

    private Date xdate;

    private BigDecimal xprice;

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public String getXname() {
        return xname;
    }

    public void setXname(String xname) {
        this.xname = xname == null ? null : xname.trim();
    }

    public String getXtype() {
        return xtype;
    }

    public void setXtype(String xtype) {
        this.xtype = xtype == null ? null : xtype.trim();
    }

    public Date getXdate() {
        return xdate;
    }

    public void setXdate(Date xdate) {
        this.xdate = xdate;
    }

    public BigDecimal getXprice() {
        return xprice;
    }

    public void setXprice(BigDecimal xprice) {
        this.xprice = xprice;
    }
}