package com.cognizant.collector.rally.beans.milestone;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;

@Data
public class Milestone {

    @Id
    @JsonProperty("ObjectID")
    private String milestoneID;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("_ref")
    private String ref;

}
