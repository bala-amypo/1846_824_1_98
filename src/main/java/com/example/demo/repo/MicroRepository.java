package com.example.demo.repo;

import com.example.demo.entity.Micro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MicroRepository extends JpaRepository<Micro, Long> {

    List<Micro> findByTagsContainingAndDifficultyAndContentType(
             String tags,
            String difficulty,
            String contentType
    );
}
