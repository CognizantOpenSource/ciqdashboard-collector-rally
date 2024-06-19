package com.cognizant.collector.rally.repository;

import com.cognizant.collector.rally.beans.milestone.*;
import org.springframework.data.mongodb.repository.*;

public interface RallyMilestoneRepository extends MongoRepository<Milestone, String> {
}
