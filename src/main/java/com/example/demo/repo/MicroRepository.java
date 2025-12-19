package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Micro;
import com.example.demo.enums.ContentType;
import com.example.demo.enums.Difficulty;

@Repository
public interface MicroRepository extends JpaRepository<Micro, Long> {

    @Query("""
        SELECT m FROM Micro m
        WHERE (:tags = '' OR m.tags LIKE %:tags%)
        AND (:difficulty IS NULL OR m.difficulty = :difficulty)
        AND (:contentType IS NULL OR m.contentType = :contentType)
    """)
    List<Micro> search(
            String tags,
            Difficulty difficulty,
            ContentType contentType
    );
}
