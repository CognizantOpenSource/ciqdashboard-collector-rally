package com.cognizant.collector.rally.beans.execution;

import com.cognizant.collector.rally.beans.testcase.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Data
@Document(collection = "#{T(com.cognizant.collector.rally.component.CommonUtilComponent).getRallyCollectionName()}")
public class Execution {

    @Id
    @JsonProperty("ObjectID")
    private String executionID;

    @JsonProperty("_ref")
    private String ref;

    private String type = "Test Run";

    @JsonProperty("CreationDate")
    private Date creationDate;

    @JsonProperty("Project")
    @Setter(AccessLevel.NONE)
    private String projectName;

    public void setProjectName(Object projectName) {
        if(projectName != null) this.projectName = (String) ((Map) projectName).get("_refObjectName");
    }

    @JsonProperty("Workspace")
    @Setter(AccessLevel.NONE)
    private String workspaceName;

    public void setWorkspaceName(Object workspaceName) {
        if(workspaceName != null) this.workspaceName = (String) ((Map) workspaceName).get("_refObjectName");
    }

    @JsonProperty("Attachments")
    @Setter(AccessLevel.NONE)
    private Integer attachments;

    public void setAttachments(Object attachments) {
        if(attachments != null) this.attachments = (Integer) ((Map) attachments).get("Count");
    }

    @JsonProperty("Build")
    private String build;

    @JsonProperty("Date")
    private Date executionDate;

    @JsonProperty("Duration")
    private Double duration;

    @JsonProperty("TestCase")
    private TestCase testCase;

    @JsonProperty("TestSet")
    @Setter(AccessLevel.NONE)
    private String testSet;

    public void setTestSet(Object testSet) {
        if(testSet!=null) this.testSet = (String) ((Map) testSet).get("_refObjectName");
    }

    @JsonProperty("Tester")
    @Setter(AccessLevel.NONE)
    private String tester;

    public void setTester(Object tester) {
        if(tester!=null) this.tester = (String) ((Map) tester).get("_refObjectName");
    }

    @JsonProperty("Verdict")
    private String verdict;

}
