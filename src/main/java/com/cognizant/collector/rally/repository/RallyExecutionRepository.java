package com.cognizant.collector.rally.repository;

import com.cognizant.collector.rally.beans.execution.*;
import org.springframework.data.mongodb.repository.*;

import java.util.*;

public interface RallyExecutionRepository extends MongoRepository<Execution, String> {

    List<Execution> findByWorkspaceNameAndProjectName(String workspaceName, String projectName);

}
