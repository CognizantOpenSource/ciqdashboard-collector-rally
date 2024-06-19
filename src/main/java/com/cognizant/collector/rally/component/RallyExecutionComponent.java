package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.execution.*;
import com.cognizant.collector.rally.client.*;
import com.cognizant.collector.rally.constants.*;
import com.cognizant.collector.rally.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.util.*;
import java.util.stream.*;

@Component
@Slf4j
public class RallyExecutionComponent {

    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyExecutionService rallyExecutionService;


    public void getExecutionDetails(String projectRef, String workspaceName, String projectName) {

        List<Execution> executionList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyExecutiondetails executiondetails = rallyClient.getExecutionDetails(projectRef, Constant.fetch, pageSize, startAt);

            int totalResults = executiondetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {

                executionList.addAll(executiondetails.getQueryResult().getObjects());

                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(executionList)) {
            storeExecutionsInDB(executionList);
            removeDeletedExecutionFromDB(executionList, workspaceName, projectName);
        }

    }

    private void removeDeletedExecutionFromDB(List<Execution> executionLis, String workspaceName, String projectName) {

        List<String> executionIDListInResponse = executionLis.stream().map(Execution::getExecutionID).collect(Collectors.toList());
        List<String> executionIDListInDB = rallyExecutionService.findByWorkspaceNameAndProjectName(workspaceName, projectName).stream().map(Execution::getExecutionID).collect(Collectors.toList());

        executionIDListInDB.removeAll(executionIDListInResponse);

        executionIDListInDB.forEach(deletedExecutionID -> {
            rallyExecutionService.deleteByID(deletedExecutionID);
        });

    }

    private void storeExecutionsInDB(List<Execution> executionList) {
        rallyExecutionService.saveAll(executionList);
    }

}
