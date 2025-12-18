package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.Userservice;

@RestController
@RequestMapping("/location")
public class AuthController {

    @Autowired
    public Userservice lcs;

    @PostMapping
    public User createUser(@RequestBody User loc) {
        return lcs.createUser(loc);
    }

    @GetMapping
    public List<Location> getAll() {
        return lcs.getAllDetails();
    }
}
