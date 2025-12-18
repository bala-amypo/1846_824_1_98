package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
