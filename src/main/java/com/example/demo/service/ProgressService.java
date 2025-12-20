package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProgressRequestDTO;
import com.example.demo.entity.Progress;

public interface ProgressService {

    Progress recordProgress(Long userId, Long lessonId, ProgressRequestDTO dto);

    Progress getProgress(Long userId, Long lessonId);

    List<Progress> getUserProgress(Long userId);
}
