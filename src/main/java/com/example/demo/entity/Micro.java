package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

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
    @Size(min=1,max=15)
    private int duration;
    private LocalDateTime date;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getdate() {
        return date;
    }
    public void setdate(LocalDateTime date) {
        this.date = date;
    }
    

    public int getduration() {
        return duration;
    }
    public void setduration(int duration) {
        this.duration = duration;
    }

    public String getdiff() {
        return diff;
    }
    public void setdiff(String diff) {
        this.diff = diff;
    }


    public String getcontentType() {
        return contentType;
    }
    public void setcontentType(String contentType) {
        this.contentType = contentType;
    }

    public String getcourse() {
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

    public String gettags(){
        return tags;
    }
    public void settags(String tags){
        this.tags=tags;
    }

    public Micro(Long id,String title,String contentType,String tags,String course,String diff,
    LocalDateTime date,int duration){
         this.id = id;
         this.title=title;
         this.contentType=contentType;
         this.tags=tags;
         this.course=course;
         this.diff=diff;
         this.date=date;
         this.duration=duration;
}
public Micro(){}
}