package com.matrix.cnative.logistics;

import java.math.BigDecimal;
import java.util.Date;


public class Order {

    public Order() {
    }

    public Order(Integer id, String goodName, int count, BigDecimal price, String address, String status) {
        this.id = id;
        this.goodName = goodName;
        this.count = count;
        this.price = price;
        this.address = address;
        this.status = status;
    }

    private Integer id;

    private String goodName;

    private int count;

    private BigDecimal  price;

    private String address;


    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
