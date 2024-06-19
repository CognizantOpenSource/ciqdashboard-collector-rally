package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.recyclebin.*;
import com.cognizant.collector.rally.client.*;
import com.cognizant.collector.rally.constants.*;
import com.cognizant.collector.rally.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.util.*;

@Component
@Slf4j
public class RallyRecycleBinComponent {

    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyUSerStoryService rallyUSerStoryService;
    @Autowired
    RallyTestCaseService rallyTestCaseService;
    @Autowired
    RallyDefectService rallyDefectService;

    public void removeDeletedComponents(String workspaceRef) {


        List<RecycleBin> recycleBinList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyRecycleBinDetails recycleBinDetails = rallyClient.getRecycleBinEntries(workspaceRef, Constant.fetch, pageSize, startAt);
            int totalResults = recycleBinDetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {
                recycleBinList.addAll(recycleBinDetails.getQueryResult().getObjects());
                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(recycleBinList)) {
            recycleBinList.forEach(recycleBinEntry -> {
                removeDeletedComponentsFromDB(recycleBinEntry.getDeletedObjectID(), recycleBinEntry.getType());
            });
        }
    }

    private void removeDeletedComponentsFromDB(String deletedObjectID, Object type) {

        switch (String.valueOf(type)) {

            case Constant.USERSTORY_TYPE:
                rallyUSerStoryService.deleteByID(deletedObjectID);
                break;
            case Constant.DEFECT_TYPE:
                rallyDefectService.deleteByID(deletedObjectID);
                break;
            case Constant.TESTCASE_TYPE:
                rallyTestCaseService.deleteByID(deletedObjectID);
                break;

        }

    }
}
