package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.userstory.*;
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
public class RallyUserStoryComponent {

    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyUSerStoryService rallyUSerStoryService;

    public void getUserStoryDetails(String projectRef) {



        List<UserStory> userStoryList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyUserStoryDetails userStoryDetails = rallyClient.getUserStoryDetails(projectRef, Constant.fetch, pageSize, startAt);

            int totalResults = userStoryDetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {

                userStoryList.addAll(userStoryDetails.getQueryResult().getObjects());

                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(userStoryList)) {
            storeUserStories(userStoryList);
        }

    }

    private void storeUserStories(List<UserStory> userStoryList) {
        rallyUSerStoryService.saveAll(userStoryList);
    }


}
