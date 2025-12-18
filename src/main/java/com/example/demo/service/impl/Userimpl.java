package com.example.demo.service.impl;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.Userservice;
import com.example.demo.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userimpl implements Userservice {

    @Autowired
    public UserRepository urp;
    public User register(User user){
        urp.save(user);
    }
    public User findById(Long id){
        return urp.findById(id).orElse(Null);
    }
    public User findByEmail(String email){
        return urp.findByEmail(email);
    }
    public AuthResponse login(String email,String password){
        User user=urp.findByEmail(email);
        if(user==null){
            return new AuthResponse("User not found",false);
        }
         if (!user.getPassword().equals(password)) {
            return new AuthResponse("Invalid password", false);
        }

        return new AuthResponse("Login successful", true);
    }
}
