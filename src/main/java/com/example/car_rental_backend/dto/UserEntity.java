package com.example.car_rental_backend.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import static jakarta.persistence.GenerationType.IDENTITY;
import java.io.File;

@Entity
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    private String role;
    private File image;  // Store image as Base64 string

}
