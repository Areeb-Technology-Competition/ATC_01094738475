package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.roles.UserRole;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleFactory roleFactory;

    public String getUserDashboard(Long userId) {
        User user = userRepository.findById(userId)
                                  .orElseThrow(() -> new RuntimeException("User not found"));

        UserRole roleHandler = roleFactory.createRole(user.getRole());
        return roleHandler.getDashboard();
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        try {
                return userRepository.save(user);
            } catch (Exception e) {
                logger.error("Failed to save user: {}", user, e);
                throw e;
        }    
    }

    // public Optional<User> findById(Long id) {
    //     return userRepository.findById(id);
    // }



}
