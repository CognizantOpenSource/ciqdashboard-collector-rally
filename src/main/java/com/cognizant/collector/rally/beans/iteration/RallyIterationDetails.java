package com.cognizant.collector.rally.beans.iteration;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;

public class RallyIterationDetails {

    @JsonProperty("QueryResult")
    QueryResult<Iteration> queryResult;

}

