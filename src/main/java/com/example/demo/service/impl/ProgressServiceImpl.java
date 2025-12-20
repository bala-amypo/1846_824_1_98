package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProgressRequestDTO;
import com.example.demo.entity.Micro;
import com.example.demo.entity.Progress;
import com.example.demo.entity.User;
import com.example.demo.enums.ProgressStatus;
import com.example.demo.repo.MicroRepository;
import com.example.demo.repo.ProgressRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.ProgressService;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MicroRepository microRepository;

    @Override
    public Progress recordProgress(Long userId, Long lessonId, ProgressRequestDTO dto) {

        User user = userRepository.findById(userId).orElseThrow();
        Micro lesson = microRepository.findById(lessonId).orElseThrow();

        if (dto.getProgressPercent() < 0 || dto.getProgressPercent() > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100");
        }

        if (dto.getStatus() == ProgressStatus.COMPLETED &&
            dto.getProgressPercent() != 100) {
            throw new IllegalArgumentException("Completed lesson must be 100%");
        }

        Progress progress = new Progress();
        progress.setUser(user);
        progress.setMicroLesson(lesson);
        progress.setStatus(dto.getStatus());
        progress.setProgressPercent(dto.getProgressPercent());
        progress.setScore(dto.getScore());

        return progressRepository.save(progress);
    }

    @Override
    public Progress getProgress(Long userId, Long lessonId) {
        User user = userRepository.findById(userId).orElseThrow();
        Micro lesson = microRepository.findById(lessonId).orElseThrow();

        return progressRepository.findByUserAndMicroLesson(user, lesson)
                .orElseThrow();
    }

    @Override
    public List<Progress> getUserProgress(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return progressRepository.findByUser(user);
    }
}
