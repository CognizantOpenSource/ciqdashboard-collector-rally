package com.cognizant.collector.rally.beans.project;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyProjectDetails {

    @JsonProperty("QueryResult")
    QueryResult<Project> queryResult;

}

