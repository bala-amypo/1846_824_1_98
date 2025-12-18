package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;
import com.example.demo.service.Userservice;

@RestController
public class AuthController {

    @Autowired
    public Userservice lcs;

    @PostMapping("/user")
    public User AddUser(@RequestBody User loc) {
        return lcs.Createuser(loc);
    }

    @GetMapping
    public List<User> getAll() {
        return lcs.getAllDetails();
    }
}
