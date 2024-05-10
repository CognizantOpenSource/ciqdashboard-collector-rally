package com.cognizant.collector.rally.beans.userstory;

import com.cognizant.collector.rally.beans.common.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallyUserStoryDetails {

    @JsonProperty("QueryResult")
    private QueryResult<UserStory> queryResult;

}


