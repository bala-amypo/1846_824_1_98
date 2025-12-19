package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MicroRequestDTO;
import com.example.demo.entity.*;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.MicroRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private MicroRepository microRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Micro addLesson(Long courseId, MicroRequestDTO dto) {

        Course course = courseRepo.findById(courseId).orElse(null);

        Micro micro = new Micro();
        micro.setCourse(course);
        micro.setTitle(dto.getTitle());
        micro.setDurationMinutes(dto.getDurationMinutes());
        micro.setTags(dto.getTags());
        micro.setDifficulty(Difficulty.valueOf(dto.getDifficulty()));
        micro.setContentType(ContentType.valueOf(dto.getContentType()));

        return microRepo.save(micro);
    }

    @Override
    public Micro updateLesson(Long lessonId, MicroRequestDTO dto) {

        Micro existing = getLesson(lessonId);
        if (existing != null) {
            existing.setTitle(dto.getTitle());
            existing.setDurationMinutes(dto.getDurationMinutes());
            existing.setTags(dto.getTags());
            existing.setDifficulty(Difficulty.valueOf(dto.getDifficulty()));
            existing.setContentType(ContentType.valueOf(dto.getContentType()));
            return microRepo.save(existing);
        }
        return null;
    }

    @Override
    public Micro getLesson(Long lessonId) {
        return microRepo.findById(lessonId).orElse(null);
    }

    @Override
    public List<Micro> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType) {

        return microRepo.findByTagsContainingAndDifficultyAndContentType(
                tags,
                Difficulty.valueOf(difficulty),
                ContentType.valueOf(contentType)
        );
    }
}
