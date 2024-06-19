package com.cognizant.collector.rally.beans.release;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;

@Data
//    @Document(collection = "rally-release")
public class Release {

    @JsonProperty("ObjectID")
    @Id
    private String releaseID;

    @JsonProperty("Name")
    @JsonAlias("_refObjectName")
    private String name;

    @JsonProperty("_ref")
    private String ref;
}
