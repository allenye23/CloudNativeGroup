package com.matrix.cnative.order;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "n_orders")
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "good_name",nullable = false,length = 100)
    private String goodName;

    @Column(name = "good_count",nullable = false,length = 100)
    private int count;

    @Column(name = "price",nullable = false,length = 10,scale = 2)
    private BigDecimal  price;

    @Column(name = "address",nullable = false,length = 200)
    private String address;

    @Column(name = "order_status",nullable = false,length = 200)
    private String status;

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
