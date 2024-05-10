package com.cognizant.collector.rally.service;

import com.cognizant.collector.rally.beans.testcase.*;
import com.cognizant.collector.rally.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RallyTestCaseService {

    @Autowired
    RallyTestCaseRepository rallyTestCaseRepository;

    public void saveAll(List<TestCase> testCases) {
        rallyTestCaseRepository.saveAll(testCases);
    }

    public void deleteByID(String testCaseID) {
        rallyTestCaseRepository.deleteById(testCaseID);
    }
}
