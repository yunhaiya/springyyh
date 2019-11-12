/**
 * Copyright (C), 2019, 金科教育
 * FileName: Car
 * Author:   zyl
 * Date:     2019/11/4 10:27
 * History:
 * zyl          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;
import java.util.Date;



public class Car implements Serializable{

    private static final long serialVersionUID = -5041234540662247442L;
    private Integer carId;

    private String carName;

    private Date carTime;

    private String carShow;

    private Double  carPrice;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getCarTime() {
        return carTime;
    }

    public void setCarTime(Date carTime) {
        this.carTime = carTime;
    }

    public String getCarShow() {
        return carShow;
    }

    public void setCarShow(String carShow) {
        this.carShow = carShow;
    }

    public Double  getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double  carPrice) {
        this.carPrice = carPrice;
    }
}
