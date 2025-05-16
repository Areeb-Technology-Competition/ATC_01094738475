package com.example.demo.services;

import org.springframework.stereotype.Component;

import com.example.demo.services.roles.AdminRole;
import com.example.demo.services.roles.RegularUserRole;
import com.example.demo.services.roles.UserRole;

@Component
public class RoleFactory {
        public UserRole createRole(String role) {
        switch (role.toLowerCase()) {
            case "admin": return new AdminRole();
            case "user": return new RegularUserRole();
            default: throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

}
