package com.example.car_rental_backend.repository;
import com.example.car_rental_backend.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsername(String username);

}
