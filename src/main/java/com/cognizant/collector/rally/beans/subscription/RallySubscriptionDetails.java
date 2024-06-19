package com.cognizant.collector.rally.beans.subscription;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class RallySubscriptionDetails {

    @JsonProperty("Subscription")
    private Subscription subscription;


    @Data
    public static class Subscription {

        @JsonProperty("_ref")
        private String _ref;

        @JsonProperty("_refObjectUUID")
        private String _refObjectUUID;

        @JsonProperty("_objectVersion")
        private String _objectVersion;

        @JsonProperty("_refObjectName")
        private String _refObjectName;

        @JsonProperty("ObjectID")
        private String subscriptionID;

    }


}


