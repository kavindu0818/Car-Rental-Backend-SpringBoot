package com.example.car_rental_backend.security;

import com.example.car_rental_backend.filter.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private AuthTokenFilter authTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for stateless applications
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/login").permitAll()  // Public login endpoint
                        .requestMatchers("/api/v1/users/save").permitAll()  // Public signup endpoint
                        .requestMatchers("/api/v1/users/**").authenticated()
                        .requestMatchers("/api/v1/get/**").permitAll()
                        .requestMatchers("/api/car/add").permitAll()// Require authentication for user-related endpoints
                        .requestMatchers("/api/car/**").permitAll()  // Public access to car-related endpoints
                        .requestMatchers("/api/cus/**").permitAll() 
                        .requestMatchers("/api/cus/update/**").authenticated() // Public access to car-related endpoints
                        .requestMatchers("/api/booking/**").permitAll()  // Public access to car-related endpoints
                        .requestMatchers("/api/history/**").permitAll()  // Public access to car-related endpoints
                        .requestMatchers("/api/history/get").permitAll()  // Public access to car-related endpoints
                        .anyRequest().authenticated()  // Other endpoints require authentication
                )
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)  // Add the authentication filter
                .cors(cors -> cors.configurationSource(corsConfigurationSource()));  // Enable CORS

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Set allowed origins to specific addresses instead of '*' for security
        configuration.setAllowedOrigins(List.of("http://localhost:5174","http://localhost:5173"));  // Only allow specific frontend origin
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));  // Allow specific headers
        configuration.setAllowCredentials(true);  // Allow credentials like cookies or authorization headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // Apply the configuration to all paths
        return source;
    }
}
