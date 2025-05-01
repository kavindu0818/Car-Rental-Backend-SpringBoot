package com.example.car_rental_backend.dao;
import com.example.car_rental_backend.entity.OnlineBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OnlineBookingDao extends JpaRepository<OnlineBookingEntity, String> {
}
