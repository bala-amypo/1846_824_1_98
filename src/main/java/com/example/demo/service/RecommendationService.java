package com.example.demo.service;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.model.Recommendation;

import java.time.LocalDate;
import java.util.List;

public interface RecommendationService {
    Recommendation generate(Long userId, RecommendationRequest request);
    Recommendation getLatest(Long userId);
    List<Recommendation> getByDateRange(Long userId, LocalDate from, LocalDate to);
}
