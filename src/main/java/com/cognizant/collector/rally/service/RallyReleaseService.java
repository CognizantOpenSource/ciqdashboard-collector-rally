package com.cognizant.collector.rally.service;

import com.cognizant.collector.rally.beans.release.*;
import com.cognizant.collector.rally.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RallyReleaseService {

    @Autowired
    RallyReleaseRepository rallyReleaseRepository;

    public void save(Release release) {
        rallyReleaseRepository.save(release);
    }

    public void saveAll(List<Release> releaseList) {
        rallyReleaseRepository.saveAll(releaseList);
    }
}
