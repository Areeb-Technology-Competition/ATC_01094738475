package com.example.demo.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.services.roles.UserRole;

import java.util.Map;

@Component
public class RoleInterceptor implements HandlerInterceptor {

    @Autowired
    private Map<String, UserRole> accessControlServices;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("role") == null) {
            response.sendRedirect("/login");
            return false;
        }

        String role = (String) session.getAttribute("role");
        String path = request.getRequestURI();

        UserRole accessControlService = accessControlServices.get(role + "AccessControl");

        if (accessControlService != null && !accessControlService.getPermittedPages().contains(path)) {
            response.sendRedirect("/access-denied");
            return false;
        }

        return true;
    }
}
