package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MicroRequestDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Micro;
import com.example.demo.enums.ContentType;
import com.example.demo.enums.Difficulty;
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

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Micro micro = new Micro();
        micro.setCourse(course);
        micro.setTitle(dto.getTitle());
        micro.setDurationMinutes(dto.getDurationMinutes());
        micro.setTags(dto.getTags());

        micro.setDifficulty(
                Difficulty.valueOf(dto.getDifficulty().toUpperCase())
        );
        micro.setContentType(
                ContentType.valueOf(dto.getContentType().toUpperCase())
        );

        return microRepo.save(micro);
    }

    @Override
    public Micro updateLesson(Long lessonId, MicroRequestDTO dto) {

        Micro existing = microRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        existing.setTitle(dto.getTitle());
        existing.setDurationMinutes(dto.getDurationMinutes());
        existing.setTags(dto.getTags());

        existing.setDifficulty(
                Difficulty.valueOf(dto.getDifficulty().toUpperCase())
        );
        existing.setContentType(
                ContentType.valueOf(dto.getContentType().toUpperCase())
        );

        return microRepo.save(existing);
    }

    @Override
    public Micro getLesson(Long lessonId) {
        return microRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @Override
    public List<Micro> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType) {

        if (tags == null) tags = "";
        Difficulty diff = difficulty != null
                ? Difficulty.valueOf(difficulty.toUpperCase())
                : null;

        ContentType type = contentType != null
                ? ContentType.valueOf(contentType.toUpperCase())
                : null;

        return microRepo.search(tags, diff, type);
    }
}
