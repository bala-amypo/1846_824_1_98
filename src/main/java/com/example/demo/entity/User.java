package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private  String fullname;
    private  String email;
    private String password;
    private String role;
    private String prefferedLearningStyle;
    private String createdAt;
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname(String name){
        return fullname;
   }
   public void setFullname(String name){
    this.fullname=name
   }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpass(){
        return password;
    }
    public void setpass(String pass){
        this.password=pass;
    }

    public String getprefer(){
        return prefferedLearningStyle;
    }
    public void setprefer(String prefer){
        this.prefferedLearningStyle=prefer;
    }
    public 


}