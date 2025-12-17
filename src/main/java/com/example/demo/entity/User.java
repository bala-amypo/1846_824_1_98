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
    @PrePersist;
    private String createdAt;
    private String role;
    public Long getId() {
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
    public String getcreate(){
        return createdAt;
    }
    public void setcreate(String at1){
        this.createdAt=at1;
    }

    public String setrole(Server rol="LEARNER"){
        this.role=rol;
    }
    public void getrole(){
        return role;
    }
    public User(Long id,String fullname,String email,String password,String role,String prefferedLearningStyle,String createdAt){
         this.id = id;
         this.fullname=name;
         this.password=pass;
         this.prefferedLearningStyle=prefer;
         this.createdAt=at1;
         this.role=rol;
         this.email = email;
}
public User(){}
}