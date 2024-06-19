package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.project.*;
import com.cognizant.collector.rally.client.*;
import com.cognizant.collector.rally.constants.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.util.*;

@Component
@Slf4j
public class RallyProjectComponent {

    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyUserStoryComponent rallyUserStoryComponent;
    @Autowired
    RallyDefectComponent rallyDefectComponent;
    @Autowired
    RallyTestCaseComponent rallyTestCaseComponent;
    @Autowired
    RallyExecutionComponent rallyExecutionComponent;


    public void getProjectDetails(String workspaceID, String workspaceName) {

        List<Project> projectList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyProjectDetails projectDetails = rallyClient.getProjectDetails(workspaceID, pageSize, startAt);
            int totalResults = projectDetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {
                projectList.addAll(projectDetails.getQueryResult().getObjects());
                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(projectList)) {
            projectList.forEach(project -> {
                rallyUserStoryComponent.getUserStoryDetails(project.getProjectRef());
                rallyDefectComponent.getDefectDetails(project.getProjectRef());
                rallyTestCaseComponent.getTesCaseDetails(project.getProjectRef());

                rallyExecutionComponent.getExecutionDetails(project.getProjectRef(), workspaceName, project.getProjectName());

            });
        }

    }



}
