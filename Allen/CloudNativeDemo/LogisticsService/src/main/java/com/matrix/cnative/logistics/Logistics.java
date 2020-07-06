package com.matrix.cnative.logistics;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Table(name = "logistics")
@Entity
public class Logistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "order_id",nullable = false,length = 100)
    private int orderId;


    @Column(name = "address",nullable = false,length = 200)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_time")
    @LastModifiedDate
    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
