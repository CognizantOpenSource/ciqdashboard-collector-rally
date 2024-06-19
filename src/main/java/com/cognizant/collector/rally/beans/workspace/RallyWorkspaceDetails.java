package com.cognizant.collector.rally.beans.workspace;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class RallyWorkspaceDetails {

    @JsonProperty("QueryResult")
    private QueryResult<Workspace> queryResult;

}


