package com.cn.server.servicebookingcreation.repository;

import com.cn.server.servicebookingcreation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}
