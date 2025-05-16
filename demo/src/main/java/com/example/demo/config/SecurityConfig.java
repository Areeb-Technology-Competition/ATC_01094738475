package com.example.demo.config;

import com.example.demo.services.roles.AdminRole;
import com.example.demo.services.roles.RegularUserRole;
import com.example.demo.services.roles.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    @Bean
    public Map<String, UserRole> accessControlServices() {
        Map<String, UserRole> services = new HashMap<>();
        services.put("adminAccessControl", new AdminRole());
        services.put("userAccessControl", new RegularUserRole()); // Add RegularUserRole implementation
        return services;
    }
}