package com.cognizant.collector.rally.beans.release;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyReleaseDetails {

    @JsonProperty("QueryResult")
    private QueryResult<Release> queryResult;

}

