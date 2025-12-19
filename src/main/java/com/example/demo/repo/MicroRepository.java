package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Micro;
import com.example.demo.enums.ContentType;
import com.example.demo.enums.Difficulty;

public interface MicroRepository extends JpaRepository<Micro, Long> {

    List<Micro> findByTagsContainingAndDifficultyAndContentType(
            String tags,
            Difficulty difficulty,
            ContentType contentType
    );
}
