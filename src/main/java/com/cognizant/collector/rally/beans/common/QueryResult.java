package com.cognizant.collector.rally.beans.common;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class QueryResult<T> {

    @JsonProperty("TotalResultCount")
    private int totalResultCopunt;

    @JsonProperty("StartIndex")
    private int startIndex;

    @JsonProperty("PageSize")
    private int pageSize;

    @JsonProperty("Results")
    private List<T> objects;

}