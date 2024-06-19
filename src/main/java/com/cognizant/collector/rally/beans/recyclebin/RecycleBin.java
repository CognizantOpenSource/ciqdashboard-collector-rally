package com.cognizant.collector.rally.beans.recyclebin;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class RecycleBin {

    @JsonProperty("ItemOID")
    private String deletedObjectID;

    @JsonProperty("Type")
    @Setter(AccessLevel.NONE)
    private String type;

    @JsonProperty("Workspace")
    @Setter(AccessLevel.NONE)
    private String workspaceName;

    public void setWorkspaceName(Object workspaceName) {
        if(workspaceName != null) this.workspaceName = (String) ((Map) workspaceName).get("_refObjectName");
    }

    public void setType(Object type) {
        if(type != null) this.type = (String) ((Map) type).get("_refObjectName");
    }
}
