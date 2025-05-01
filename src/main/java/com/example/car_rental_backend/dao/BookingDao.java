package com.example.car_rental_backend.dao;
import com.example.car_rental_backend.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<BookingEntity,String> {
}
