package com.example.demo.services.roles;

import java.util.List;

public class RegularUserRole implements UserRole {
    @Override
    public String getDashboard() { return "user/index"; }

    @Override
    public List<String> getPermittedPages() {
        return List.of("/user/index", "/user/profile");
    }
    
}
