package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Micro;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.MicroRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceimpl implements LessonService {

    @Autowired
    private MicroRepository lessonRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Micro addLesson(Long courseId, Micro lesson) {

        Course course = courseRepo.findById(courseId).orElse(null);
        lesson.setCourse(course);

        return lessonRepo.save(lesson);
    }

    @Override
    public Micro updateLesson(Long lessonId, Micro lesson) {

        Micro existing = getLesson(lessonId);
        if (existing != null) {
            existing.setTitle(lesson.getTitle());
            existing.setDurationMinutes(lesson.getDurationMinutes());
            existing.setTags(lesson.getTags());
            existing.setDifficulty(lesson.getDifficulty());
            existing.setContentType(lesson.getContentType());
            return lessonRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<Micro> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType) {

        return lessonRepo
                .findByTagsContainingAndDifficultyAndContentType(
                        tags,
                        difficulty,
                        contentType
                );
    }

    @Override
    public Micro getLesson(Long lessonId) {
        return lessonRepo.findById(lessonId).orElse(null);
    }
}
