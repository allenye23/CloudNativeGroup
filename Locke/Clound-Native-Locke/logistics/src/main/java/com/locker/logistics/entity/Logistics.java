package com.locker.logistics.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_logistics")
public class Logistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "l_id")
    @JsonProperty
    private int id;

    @Column(name = "order_id")
    @JsonProperty
    private int oid;


    @Column(name = "order_address")
    @JsonProperty
    private String address;



}
