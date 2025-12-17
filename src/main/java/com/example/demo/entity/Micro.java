package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.LocalDateTime;

@Entity
public class Micro{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String diff;
    private String contentType;
    private String course;
    private String tags;
    private int duration;
    private LocalDateTime date;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getdate() {
        return date;
    }
    public void setdate(Long id) {
        this.date = date;
    }
    

    public int getduration() {
        return duration;
    }
    public void setduration(Long duration) {
        this.duration = duration;
    }

    public String getdiff() {
        return diff;
    }
    public void setdescription(String diff) {
        this.diff = diff;
    }


    public String getcontentType() {
        return contentType;
    }
    public void setcontentType(String contentType) {
        this.contentType = contentType;
    }

    public String getcourse(String course) {
        return course;
    }
    public void setcourse(String course) {
        this.course = course;
    }

    public String gettitle(){
        return title;
    }
    public void settitle(String title){
        this.title=title;
    }

    public String getcreate(){
        return tags;
    }
    public void setcreate(String tags){
        this.tags=tags;
    }

    public Micro(Long id,String title,String contentType,String tags,String course){
         this.id = id;
         this.title=title;
         this.contentType=contentType;
         this.tags=tags;
         this.course=course;
         
}
public Micro(){}
}