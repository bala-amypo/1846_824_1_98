package com.example.demo.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MicroRequestDTO {

    @NotBlank
    private String title;

    @Min(1)
    @Max(15)
    private Integer durationMinutes;

    @NotBlank
    private String contentType;

    @NotBlank
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
