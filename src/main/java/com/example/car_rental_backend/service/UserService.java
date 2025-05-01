package com.example.car_rental_backend.service;
import com.example.car_rental_backend.dto.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserEntity saveUser(UserEntity user);

    UserEntity getUser(String id);

}
