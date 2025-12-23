package com.example.demo.controller;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public Recommendation generate(@PathVariable Long userId,
                                   @RequestBody RecommendationRequest request) {
        return service.generate(userId, request);
    }

    @GetMapping("/latest/{userId}")
    public Recommendation latest(@PathVariable Long userId) {
        return service.getLatest(userId);
    }

    @GetMapping("/{userId}")
    public List<Recommendation> range(@PathVariable Long userId,
                                      @RequestParam LocalDate from,
                                      @RequestParam LocalDate to) {
        return service.getByDateRange(userId, from, to);
    }
}
