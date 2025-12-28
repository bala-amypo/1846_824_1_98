package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProgressRequest {

    private String status;
    private Integer progressPercent;
    private BigDecimal score;
}
