package com.example.demo.dto;

import com.example.demo.enums.ProgressStatus;

public class ProgressRequestDTO {

    private ProgressStatus status;
    private Integer progressPercent;
    private Double score;

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
