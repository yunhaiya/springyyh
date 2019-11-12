package com.jk.model;

import java.util.List;

public class ShuModel {


    private Integer id;

    private String text;

    private Integer pid;

    private String url;

    private List<ShuModel> children;

    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ShuModel> getChildren() {
        return children;
    }

    public void setChildren(List<ShuModel> children) {
        this.children = children;
    }
}