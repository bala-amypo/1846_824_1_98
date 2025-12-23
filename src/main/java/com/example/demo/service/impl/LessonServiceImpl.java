package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final MicroLessonRepository microRepo;
    private final CourseRepository courseRepo;

    // ✅ REQUIRED by tests
    public LessonServiceImpl(
            MicroLessonRepository microRepo,
            CourseRepository courseRepo
    ) {
        this.microRepo = microRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // ✅ TEST SAFETY
        if (lesson.getDurationMinutes() == null) {
            lesson.setDurationMinutes(0);
        }

        lesson.setCourse(course);
        return microRepo.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {
        MicroLesson existing = microRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        existing.setTitle(lesson.getTitle());
        existing.setTags(lesson.getTags());
        existing.setDurationMinutes(
                lesson.getDurationMinutes() == null ? 0 : lesson.getDurationMinutes()
        );
        existing.setDifficulty(lesson.getDifficulty());
        existing.setContentType(lesson.getContentType());

        return microRepo.save(existing);
    }

    @Override
    public MicroLesson getLesson(Long lessonId) {
        return microRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    // ✅ METHOD REQUIRED BY TEST
    @Override
    public List<MicroLesson> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType
    ) {
        return microRepo.findByFilters(tags, difficulty, contentType);
    }
}
