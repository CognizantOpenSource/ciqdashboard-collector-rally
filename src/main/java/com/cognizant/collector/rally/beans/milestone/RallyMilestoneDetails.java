package com.cognizant.collector.rally.beans.milestone;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;

public class RallyMilestoneDetails {

    @JsonProperty("QueryResult")
    QueryResult<Milestone> queryResult;

}

