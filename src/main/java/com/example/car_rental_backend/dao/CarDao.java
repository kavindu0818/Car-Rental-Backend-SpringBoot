package com.example.car_rental_backend.dao;
import com.example.car_rental_backend.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<CarEntity, String> {
}
