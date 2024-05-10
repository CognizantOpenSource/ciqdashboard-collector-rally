package com.cognizant.collector.rally.service;

import com.cognizant.collector.rally.beans.defect.*;
import com.cognizant.collector.rally.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RallyDefectService {

    @Autowired
    RallyDefectRepository rallyDefectRepository;

    public void saveAll(List<Defect> defects) {
        rallyDefectRepository.saveAll(defects);
    }

    public void deleteByID(String defectID) {
        rallyDefectRepository.deleteById(defectID);
    }
}
