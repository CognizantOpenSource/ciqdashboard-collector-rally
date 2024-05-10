package com.cognizant.collector.rally.beans.common;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class WorkProductDetails {

    @JsonProperty("_ref")
    private String ref;

    @JsonProperty("_refObjectName")
    private String name;

    @JsonProperty("_type")
    private String type;

}
