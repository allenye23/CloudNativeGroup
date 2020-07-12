package com.locker.logistics.dao;

import com.locker.logistics.entity.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsDao extends JpaRepository<Logistics, Integer> {



}
