package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.NotNull;
import jakarta.persistence.PrePersist;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private  String fullname;
    @Column(unique=true)
    private  String email;
    private String password;
    private String role;
    @NotNull(message="not null")
    private String prefferedLearningStyle;
    private String createdAt;
    private String role;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname(String fullname){
        return fullname;
   }
   public void setFullname(String fullname){
    this.fullname=fullname;
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
    public void setpass(String password){
        this.password=password;
    }

    public String getprefer(){
        return prefferedLearningStyle;
    }
    public void setprefer(String prefferedLearningStyle){
        this.prefferedLearningStyle=prefferedLearningStyle;
    }
    public String getcreate(){
        return createdAt;
    }
    public void setcreate(String createdAt){
        this.createdAt=createdAt;
    }

    public String setrole(String role){
        this.role=role;
    }
    public void getrole(){
        return role;
    }
    public User(Long id,String fullname,String email,String password,String role,String prefferedLearningStyle,String createdAt){
         this.id = id;
         this.fullname=fullname;
         this.password=password;
         this.prefferedLearningStyle=prefferedLearningStyle;
         this.createdAt=createdAt;
         this.role=role;
         this.email = email;
}
public User(){}
}