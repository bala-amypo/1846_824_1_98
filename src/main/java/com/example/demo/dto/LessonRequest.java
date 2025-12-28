package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LessonRequest {

    private String title;
    private Integer durationMinutes;
    private String contentType;
    private String difficulty;
    private String tags;
    private LocalDate publishDate;
}
