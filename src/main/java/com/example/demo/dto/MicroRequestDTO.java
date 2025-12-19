package com.example.demo.dto;

public class MicroRequestDTO {

    private String title;
    private Integer durationMinutes;
    private String contentType;
    private String difficulty;
    private String tags;

    public String getTitle() { return title; }
    public Integer getDurationMinutes() { return durationMinutes; }
    public String getContentType() { return contentType; }
    public String getDifficulty() { return difficulty; }
    public String getTags() { return tags; }

    public void setTitle(String title) { this.title = title; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setTags(String tags) { this.tags = tags; }
}
