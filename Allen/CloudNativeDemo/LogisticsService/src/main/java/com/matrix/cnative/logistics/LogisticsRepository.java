package com.matrix.cnative.logistics;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LogisticsRepository extends CrudRepository<Logistics,Integer>{
    Optional<Logistics> findByOrderId(Integer id);
}
