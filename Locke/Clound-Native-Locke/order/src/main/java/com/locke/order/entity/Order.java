package com.locke.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonProperty
    private int id;

    @JsonProperty
    @Column(name = "order_name")
    private String orderName;

    @JsonProperty
    @Column(name = "order_quantity")
    private int quantity;

    @JsonProperty
    @Column(name = "order_address", nullable = false)
    private String address;

}
