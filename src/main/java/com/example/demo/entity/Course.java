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

    public Course(Long id,String description,String description,String createdAt){
         this.id = id;
         this.title=title;
         this.description=description;
         this.createdAt=createdAt;
         this.description=description;
         
}
public Course(){}
}