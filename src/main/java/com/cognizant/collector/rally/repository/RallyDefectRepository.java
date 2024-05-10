package com.cognizant.collector.rally.repository;

import com.cognizant.collector.rally.beans.defect.*;
import org.springframework.data.mongodb.repository.*;

public interface RallyDefectRepository extends MongoRepository<Defect, String> {

}
