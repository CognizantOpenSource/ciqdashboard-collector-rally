package com.cognizant.collector.rally.beans.testcase;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyTestCaseDetails  {

    @JsonProperty("QueryResult")
    private QueryResult<TestCase> queryResult;

}

