package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Course{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    @NotNull
    private String discription;
    private String category;
    private String createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getdiscription() {
        return description;
    }
    public void setId(Long id) {
        this.description = description;
    }

    public Long getcategory() {
        return description;
    }
    public void setcategory(Long id) {
        this.category = category;
    }

    public String getcreate(){
        return createdAt;
    }
    public void setcreate(String createdAt){
        this.createdAt=createdAt;
    }

    public User(Long id,String role,String prefferedLearningStyle,String createdAt){
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