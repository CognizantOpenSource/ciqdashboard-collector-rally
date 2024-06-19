package com.cognizant.collector.rally.beans.workspace;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class Workspace {

    @JsonProperty("ObjectID")
    private String workspaceID;

    @JsonProperty("ObjectName")
    @JsonAlias("_refObjectName")
    private String workspaceName;

    @JsonProperty("_ref")
    private String workspaceRef;

}
