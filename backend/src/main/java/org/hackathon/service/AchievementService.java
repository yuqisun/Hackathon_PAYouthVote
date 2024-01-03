package org.hackathon.service;

import org.hackathon.entity.Achievement;

import java.util.List;

public interface AchievementService {
    List<Achievement> findById(Long id);

    Achievement save(Achievement achievement);
}
