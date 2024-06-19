package com.cognizant.collector.rally.beans.iteration;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class Iteration {

    @JsonProperty("ObjectID")
    private String iterationID;

    @JsonProperty("Name")
    @JsonAlias("_refObjectName")
    private String name;

    @JsonProperty("_ref")
    private String ref;

}
