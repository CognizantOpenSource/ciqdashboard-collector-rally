package com.cognizant.collector.rally.beans.recyclebin;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyRecycleBinDetails {

    @JsonProperty("QueryResult")
    QueryResult<RecycleBin> queryResult;

}
