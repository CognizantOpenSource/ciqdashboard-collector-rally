package com.cognizant.collector.rally.beans.testcase;

import com.cognizant.collector.rally.beans.common.*;
import com.cognizant.collector.rally.beans.execution.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Data
@Document(collection = "#{T(com.cognizant.collector.rally.component.CommonUtilComponent).getRallyCollectionName()}")
public class TestCase {

    @JsonProperty("ObjectID")
    @Id
    private String testCaseID;

    @JsonProperty("Name")
    @JsonAlias("_refObjectName")
    private String name;

    @JsonProperty("_ref")
    private String ref;

    private String type = "Test Case";

    @JsonProperty("Workspace")
    @Setter(AccessLevel.NONE)
    private String workspaceName;

    public void setWorkspaceName(Object workspaceName) {
        if(workspaceName != null) this.workspaceName = (String) ((Map) workspaceName).get("_refObjectName");
    }

    @JsonProperty("CreationDate")
    private Date creationDate;

    @JsonProperty("CreatedBy")
    @Setter(AccessLevel.NONE)
    private String createdBy;

    public void setCreatedBy(Object createdBy) {
        if(createdBy != null) this.createdBy = (String) ((Map) createdBy).get("_refObjectName");
    }

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Expedite")
    private Boolean expedite;

    @JsonProperty("FormattedID")
    private String formattedID;

    @JsonProperty("LastUpdateDate")
    private Date lastUpdateDate;

    @JsonProperty("Milestones")
    @Setter(AccessLevel.NONE)
    private Integer milestones;

    public void setMilestones(Object milestones) {
        this.milestones = ( (Integer) ((Map) milestones).get("Count"));
    }

    @JsonProperty("Owner")
    @Setter(AccessLevel.NONE)
    private String owner;

    public void setOwner(Object owner) {
        if(owner!=null) this.owner = (String) ((Map) owner).get("_refObjectName");
    }

    @JsonProperty("Project")
    @Setter(AccessLevel.NONE)
    private String projectName;

    public void setProjectName(Object projectName) {
        if(projectName != null) this.projectName = (String) ((Map) projectName).get("_refObjectName");
    }

    @JsonProperty("Ready")
    private Boolean ready = null;

    @JsonProperty("Attachments")
    @Setter(AccessLevel.NONE)
    private Integer attachments;

    public void setAttachments(Object attachments) {
        if(attachments != null) this.attachments = (Integer) ((Map) attachments).get("Count");
    }

    @JsonProperty("DefectStatus")
    private String defectStatus;

    @JsonProperty("Defects")
    @Setter(AccessLevel.NONE)
    private Integer defects;

    public void setDefects(Object defects) {
        if(defects != null) this.defects = (Integer) ((Map) defects).get("Count");
    }

    @JsonProperty("LastBuild")
    private String lastBuild;

    @JsonProperty("LastResult")
    private Execution lastResult;

    @JsonProperty("LastRun")
    private Date lastRun;

    @JsonProperty("LastVerdict")
    private String lastVerdict;

    @JsonProperty("Method")
    private String method;

    @JsonProperty("Package")
    private String packageInfo;

    @JsonProperty("PostConditions")
    private String postConditions;

    @JsonProperty("preConditions")
    private String preConditions;

    @JsonProperty("Priority")
    private String priority;

    @JsonProperty("Recycled")
    private Boolean recycled;

    @JsonProperty("Results")
    @Setter(AccessLevel.NONE)
    private Integer results;

    public void setResults(Object results) {
        if(results != null) this.results = ((Integer) ((Map) results).get("Count"));
    }

    @JsonProperty("Risk")
    private String risk;

    @JsonProperty("Steps")
    @Setter(AccessLevel.NONE)
    private Integer steps;

    public void setSteps(Object steps) {
        if(steps != null) this.steps = (Integer) ((Map) steps).get("Count");
    }

    @JsonProperty("TestFolder")
    @Setter(AccessLevel.NONE)
    private String testFolder;

    public void setTestFolder(Map<String, String> testFolder) {
        if(testFolder != null) this.testFolder = testFolder.get("_refObjectName");
    }

    @JsonProperty("TestSets")
    @Setter(AccessLevel.NONE)
    private Integer testSets;

    public void setTestSets(Object testSets) {
        if(testSets != null) this.testSets = (Integer) ((Map)testSets).get("Count");
    }

    @JsonProperty("Type")
    private String testType;

    @JsonProperty("ValidationExpectedResult")
    private String validationExpectedResult;

    @JsonProperty("ValidationInput")
    private String validationInput;

    @JsonProperty("WorkProduct")
    private WorkProductDetails workProduct;

}
