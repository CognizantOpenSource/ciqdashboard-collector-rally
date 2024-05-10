package com.cognizant.collector.rally.beans.defect;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyDefectDetails {

    @JsonProperty("QueryResult")
    QueryResult<Defect> queryResult;

}

