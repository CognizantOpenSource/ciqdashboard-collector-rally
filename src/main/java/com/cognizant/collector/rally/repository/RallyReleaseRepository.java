package com.cognizant.collector.rally.repository;

import com.cognizant.collector.rally.beans.release.*;
import org.springframework.data.mongodb.repository.*;

public interface RallyReleaseRepository extends MongoRepository<Release, String> {



}
