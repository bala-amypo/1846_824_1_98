package com.example.demo.service.impl;
import com.example.demo.repo.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.Userservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Userimpl implements Userservice{
    @Autowired
    UserRepository lrp;
    public User createUser(User user){
        return lrp.save(user);
    }
    public List<User> getAllDetails(){
        return lrp.findAll();
    }
}