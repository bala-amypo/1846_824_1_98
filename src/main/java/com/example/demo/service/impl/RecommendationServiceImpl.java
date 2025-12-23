package com.example.demo.service.impl;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository repo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public RecommendationServiceImpl(RecommendationRepository repo,
                                     UserRepository userRepo,
                                     MicroLessonRepository lessonRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Recommendation generate(Long userId, RecommendationRequest req) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<MicroLesson> lessons =
                lessonRepo.findByTagsContainingAndDifficultyAndContentType(
                        req.getTags(), req.getDifficulty(), "VIDEO");

        String lessonIds = lessons.stream()
                .limit(req.getMaxItems())
                .map(l -> l.getId().toString())
                .collect(Collectors.joining(","));

        Recommendation rec = Recommendation.builder()
                .user(user)
                .recommendedLessonIds(lessonIds)
                .basisSnapshot("Auto-generated")
                .confidenceScore(BigDecimal.valueOf(0.85))
                .build();

        return repo.save(rec);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return repo.findByUserIdOrderByGeneratedAtDesc(userId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No recommendations found"));
    }

    @Override
    public List<Recommendation> getByDateRange(Long userId,
                                               LocalDate from,
                                               LocalDate to) {
        return repo.findByUserIdAndGeneratedAtBetween(
                userId,
                from.atStartOfDay(),
                to.atTime(23, 59));
    }
}
