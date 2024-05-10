package com.cognizant.collector.rally.component;

import com.cognizant.collector.rally.beans.subscription.*;
import com.cognizant.collector.rally.client.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
@Slf4j
public class RallyComponent {

    @Autowired
    RallyWorkspaceComponent rallyWorkspaceComponent;
    @Autowired
    RallyClient rallyClient;

    public void getRallyDetails() {

        RallySubscriptionDetails rallySubscriptionDetails = rallyClient.getSubscriptionDetails();
        rallyWorkspaceComponent.getWorkspaceDetails(rallySubscriptionDetails.getSubscription().getSubscriptionID());

    }

}
