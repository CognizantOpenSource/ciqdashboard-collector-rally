package com.cognizant.collector.rally.service;

import com.cognizant.collector.rally.beans.execution.*;
import com.cognizant.collector.rally.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RallyExecutionService {

    @Autowired
    RallyExecutionRepository rallyExecutionRepository;

    public void saveAll(List<Execution> executions) {
        rallyExecutionRepository.saveAll(executions);
    }

    public List<Execution> findAll() {
        return rallyExecutionRepository.findAll();
    }

    public List<Execution> findByWorkspaceNameAndProjectName(String workspaceName, String projectName) {
        return rallyExecutionRepository.findByWorkspaceNameAndProjectName(workspaceName, projectName);
    }

    public void deleteByID(String executionID) {
        rallyExecutionRepository.deleteById(executionID);
    }
}
