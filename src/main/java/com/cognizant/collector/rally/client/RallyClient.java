/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.rally.client;

import com.cognizant.collector.rally.beans.defect.*;
import com.cognizant.collector.rally.beans.execution.*;
import com.cognizant.collector.rally.beans.project.*;
import com.cognizant.collector.rally.beans.recyclebin.*;
import com.cognizant.collector.rally.beans.subscription.*;
import com.cognizant.collector.rally.beans.testcase.*;
import com.cognizant.collector.rally.beans.userstory.*;
import com.cognizant.collector.rally.beans.workspace.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * RallyClient - Refers to rally server API's
 * @author Cognizant
 */

public interface RallyClient {

    @GetMapping(value="/subscription", produces=MediaType.APPLICATION_JSON_VALUE)
    RallySubscriptionDetails getSubscriptionDetails();

    @GetMapping(value="/subscription/{subscriptionID}/Workspaces", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyWorkspaceDetails getWorkspaceDetails(
            @PathVariable(name = "subscriptionID") String subscriptionID,
            @RequestParam int pagesize,
            @RequestParam int start
    );

    @GetMapping(value="/workspace/{workspaceID}/Projects", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyProjectDetails getProjectDetails(
            @PathVariable(name = "workspaceID") String workspaceID,
            @RequestParam int pagesize,
            @RequestParam int start
    );

    @GetMapping(value="/HierarchicalRequirement", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyUserStoryDetails getUserStoryDetails(
        @RequestParam String project,
        @RequestParam boolean fetch,
        @RequestParam int pagesize,
        @RequestParam int start
    );

    @GetMapping(value="/testcase", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyTestCaseDetails getTestCaseDetails(
            @RequestParam String project,
            @RequestParam boolean fetch,
            @RequestParam int pagesize,
            @RequestParam int start
    );

    @GetMapping(value="/defect", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyDefectDetails getDefectDetails(
            @RequestParam String project,
            @RequestParam boolean fetch,
            @RequestParam int pagesize,
            @RequestParam int start
    );

    @GetMapping(value="/testcaseresult", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyExecutiondetails getExecutionDetails(
            @RequestParam String project,
            @RequestParam boolean fetch,
            @RequestParam int pagesize,
            @RequestParam int start
    );

    @GetMapping(value = "/recyclebinentry", produces=MediaType.APPLICATION_JSON_VALUE)
    RallyRecycleBinDetails getRecycleBinEntries(
            @RequestParam String workspace,
            @RequestParam boolean fetch,
            @RequestParam int pagesize,
            @RequestParam int start
    );

}
