package com.cognizant.collector.rally.repository;

import com.cognizant.collector.rally.beans.testcase.*;
import org.springframework.data.mongodb.repository.*;

public interface RallyTestCaseRepository extends MongoRepository<TestCase, String> {



}
