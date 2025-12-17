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
    private Long id;
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

    public String getdiscription() {
        return discription;
    }
    public void setdescription(String discription) {
        this.discription = discription;
    }

    public String getcategory(String category) {
        return category;
    }
    public void setcategory(String category) {
        this.category = category;
    }

    public String gettitle(){
        return title;
    }
    public void settitle(String title){
        this.title=title;
    }

    public String getcreate(){
        return createdAt;
    }
    public void setcreate(String createdAt){
        this.createdAt=createdAt;
    }

    public Course(Long id,String title,String discription,String createdAt,String category){
         this.id = id;
         this.title=title;
         this.discription=discription;
         this.createdAt=createdAt;
         this.category=category;
         
}
public Course(){}
}