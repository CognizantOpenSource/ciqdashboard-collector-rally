package com.cognizant.collector.rally.repository;

import com.cognizant.collector.rally.beans.userstory.*;
import org.springframework.data.mongodb.repository.*;

public interface RallyUSerStoryRepository extends MongoRepository<UserStory, String> {


}
