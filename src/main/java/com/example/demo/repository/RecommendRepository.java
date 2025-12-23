package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Recommendation;
import com.example.demo.entity.User;

public interface RecommendRepository extends JpaRepository<Recommendation, Long> {

    Optional<Recommendation> findTopByUserOrderByGeneratedAtDesc(User user);

    List<Recommendation> findByUserAndGeneratedAtBetween(
            User user,
            LocalDateTime from,
            LocalDateTime to
    );

    List<Recommendation> findByUser(User user);
}
