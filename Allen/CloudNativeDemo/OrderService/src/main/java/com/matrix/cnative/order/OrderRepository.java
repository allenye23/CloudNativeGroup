package com.matrix.cnative.order;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Integer>{
    Optional<Order> findById(Integer id);
}
