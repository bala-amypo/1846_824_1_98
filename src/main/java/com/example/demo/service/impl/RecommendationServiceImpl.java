package com.example.demo.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.entity.Recommendation;
import com.example.demo.entity.User;
import com.example.demo.repo.RecommendRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendRepository recommendRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Recommendation generateRecommendation(Long userId, RecommendationRequest request) {

        if (request.getConfidenceScore() < 0.0 || request.getConfidenceScore() > 1.0) {
            throw new IllegalArgumentException("Confidence score must be between 0.0 and 1.0");
        }

        User user = userRepository.findById(userId).orElseThrow();

        Recommendation recommendation = new Recommendation();
        recommendation.setUser(user);
        recommendation.setBasisSnapshot(request.getBasisSnapshot());
        recommendation.setRecommendedLessonIds(request.getRecommendedLessonIds());
        recommendation.setConfidenceScore(request.getConfidenceScore());

        return recommendRepository.save(recommendation);
    }

    @Override
    public Recommendation getLatestRecommendation(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return recommendRepository.findTopByUserOrderByGeneratedAtDesc(user)
                .orElseThrow();
    }

    @Override
    public List<Recommendation> getRecommendations(Long userId, LocalDate from, LocalDate to) {

        User user = userRepository.findById(userId).orElseThrow();

        LocalDateTime fromDate = from.atStartOfDay();
        LocalDateTime toDate = to.atTime(23, 59, 59);

        return recommendRepository.findByUserAndGeneratedAtBetween(
                user,
                fromDate,
                toDate
        );
    }
}
