package com.cognizant.collector.rally.beans.project;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class Project {

    @JsonProperty("ObjectID")
    @JsonAlias("_refObjectID")
    private String projectID;

    @JsonProperty("ObjectName")
    @JsonAlias("_refObjectName")
    private String projectName;

    @JsonProperty("_ref")
    private String projectRef;

    @JsonProperty("_CreationDate")
    private Date creationDate;

    @JsonProperty("Owner")
    @Setter(AccessLevel.NONE)
    private String owner;

    public void setOwner(Object owner) {
        if(owner!=null) this.owner = (String) ((Map) owner).get("_refObjectName");
    }

}
