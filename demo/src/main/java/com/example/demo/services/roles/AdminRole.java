package com.example.demo.services.roles;

import java.util.List;

public class AdminRole implements UserRole {
    @Override
    public String getDashboard() { return "admin/dashboard"; }

    @Override
    public List<String> getPermittedPages() {
        return List.of("/admin/dashboard", "/events/admin", "/admin/users","/user/index");  
    }
    
}
