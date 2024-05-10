package com.cognizant.collector.rally.beans.common;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class PortfolioItemDetails {

    @JsonProperty("_ref")
    private String ref;

    @JsonProperty("_refObjectName")
    private String name;

}
