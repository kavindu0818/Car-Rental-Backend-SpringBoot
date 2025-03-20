package com.example.car_rental_backend.controller;

import com.example.car_rental_backend.dto.UserEntity;
import com.example.car_rental_backend.security.JWTUtils;
import com.example.car_rental_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
@RequiredArgsConstructor // ✅ This will handle constructor injection
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private JWTUtils jwtUtils; // ✅ Remove @Autowired

    @GetMapping(path="/users/test")
    public String testing(){
        return "Thanura";
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSelectUser(@PathVariable String id) {
        try {
            System.out.println("mama user gana awa");
            UserEntity user = userService.getUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error fetching user: " + ex.getMessage());
        }
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/users/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity saveUser(@RequestBody UserEntity user) {
        System.out.println("user come"+ user.getImage());
        return userService.saveUser(user);
    }

    @PostMapping(path = "/users/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginUser(@RequestBody UserEntity loginCredentials) {
        System.out.println("mawa cl una");
        try {
            UserDetails userDetails = userService.loadUserByUsername(loginCredentials.getUsername());
            if (userDetails.getPassword().replace("{noop}", "").equals(loginCredentials.getPassword())) {
                String jwt = jwtUtils.generateJwtToken(userDetails.getUsername());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

                System.out.println(jwt);
                return new ResponseEntity<>(jwt, HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid login credentials", HttpStatus.UNAUTHORIZED);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("User does not exist", HttpStatus.UNAUTHORIZED);
        }
    }
}
