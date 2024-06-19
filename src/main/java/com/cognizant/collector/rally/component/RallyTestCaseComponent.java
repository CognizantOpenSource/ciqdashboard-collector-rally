package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.testcase.*;
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
public class RallyTestCaseComponent {

    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyTestCaseService rallyTestCaseService;

    public void getTesCaseDetails(String projectRef) {


        List<TestCase> testCaseList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyTestCaseDetails rallyTestCaseDetails = rallyClient.getTestCaseDetails(projectRef, Constant.fetch, pageSize, startAt);

            int totalResults = rallyTestCaseDetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {

                testCaseList.addAll(rallyTestCaseDetails.getQueryResult().getObjects());

                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(testCaseList)) {
            storeTestCasesInDB(testCaseList);
        }

    }

    private void storeTestCasesInDB(List<TestCase> testCaseList) {
         rallyTestCaseService.saveAll(testCaseList);
    }

}
