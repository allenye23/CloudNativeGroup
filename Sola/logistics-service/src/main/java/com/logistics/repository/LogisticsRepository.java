package com.logistics.repository;

import common.entities.Logistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogisticsRepository extends CrudRepository<Logistics, Long> {

    Optional<Logistics> findByOrderNumber(String orderNumber);
}
