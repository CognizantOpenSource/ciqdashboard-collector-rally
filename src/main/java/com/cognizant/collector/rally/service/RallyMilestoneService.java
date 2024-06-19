package com.cognizant.collector.rally.service;

import com.cognizant.collector.rally.beans.milestone.*;
import com.cognizant.collector.rally.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RallyMilestoneService {

   @Autowired
   RallyMilestoneRepository rallyMilestoneRepository;

   public void save(Milestone milestone) {
       rallyMilestoneRepository.save(milestone);
   }

    public void saveAll(List<Milestone> milestonelist) {
        rallyMilestoneRepository.saveAll(milestonelist);
    }
}
