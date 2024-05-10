package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.workspace.*;
import com.cognizant.collector.rally.client.*;
import com.cognizant.collector.rally.constants.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.util.*;

@Component
@Slf4j
public class RallyWorkspaceComponent {

    @Autowired
    RallyProjectComponent rallyProjectComponent;
    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyMilestoneComponent rallyMilestoneComponent;
    @Autowired
    RallyReleaseComponent rallyReleaseComponent;
    @Autowired
    RallyUserStoryComponent rallyUserStoryComponent;
    @Autowired
    RallyRecycleBinComponent rallyRecycleBinComponent;



    public void getWorkspaceDetails(String subscriptionID) {

        List<Workspace> workspaceList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyWorkspaceDetails workspaceDetails = rallyClient.getWorkspaceDetails(subscriptionID, pageSize, startAt);
            int totalResults = workspaceDetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {
                workspaceList.addAll(workspaceDetails.getQueryResult().getObjects());
                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(workspaceList)) {
            workspaceList.forEach(workspace -> {
                rallyProjectComponent.getProjectDetails(workspace.getWorkspaceID(), workspace.getWorkspaceName());
                rallyRecycleBinComponent.removeDeletedComponents(workspace.getWorkspaceRef());
            });
        }

    }

}
