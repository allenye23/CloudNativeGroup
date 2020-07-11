package com.cn.server.servicebookingcreation.servicebookingfinding.repository;

import com.cn.server.servicebookingcreation.servicebookingfinding.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}
