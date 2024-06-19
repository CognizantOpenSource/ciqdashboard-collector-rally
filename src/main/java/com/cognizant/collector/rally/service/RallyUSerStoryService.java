package com.cognizant.collector.rally.service;

import com.cognizant.collector.rally.beans.userstory.*;
import com.cognizant.collector.rally.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RallyUSerStoryService {

    @Autowired
    RallyUSerStoryRepository rallyUSerStoryRepository;

    public void saveAll(List<UserStory> userStories) {
        rallyUSerStoryRepository.saveAll(userStories);
    }

    public void deleteByID(String userStoryID) {
        rallyUSerStoryRepository.deleteById(userStoryID);
    }
}
