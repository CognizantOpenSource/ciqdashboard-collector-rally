package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.defect.*;
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
public class RallyDefectComponent {

    @Autowired
    RallyClient rallyClient;
    @Autowired
    RallyDefectService rallyDefectService;

    public void getDefectDetails(String projectRef) {

        List<Defect> defectList = new ArrayList<>();

        int pageSize = Constant.PAGE_SIZE;
        int startAt = Constant.START;
        boolean isCompleted = false;

        do {

            RallyDefectDetails defectDetails = rallyClient.getDefectDetails(projectRef, Constant.fetch, pageSize, startAt);

            int totalResults = defectDetails.getQueryResult().getTotalResultCopunt();

            if (totalResults == 0) {
                isCompleted = true;
            } else {

                defectList.addAll(defectDetails.getQueryResult().getObjects());

                startAt += pageSize;

                if (totalResults < startAt) {
                    isCompleted = true;
                }

            }
        } while (!isCompleted);

        if(!CollectionUtils.isEmpty(defectList)) {
            storeDefectsInDB(defectList);
        }

    }

    private void storeDefectsInDB(List<Defect> defectList) {
        rallyDefectService.saveAll(defectList);
    }

}
