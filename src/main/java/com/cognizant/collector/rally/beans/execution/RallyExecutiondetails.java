package com.cognizant.collector.rally.beans.execution;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyExecutiondetails {

    @JsonProperty("QueryResult")
    QueryResult<Execution> queryResult;


}

