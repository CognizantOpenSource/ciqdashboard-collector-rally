package com.cognizant.collector.rally.beans.defect;

import com.cognizant.collector.rally.beans.execution.*;
import com.cognizant.collector.rally.beans.iteration.*;
import com.cognizant.collector.rally.beans.release.*;
import com.cognizant.collector.rally.beans.testcase.*;
import com.cognizant.collector.rally.beans.userstory.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Data
@Document(collection = "#{T(com.cognizant.collector.rally.component.CommonUtilComponent).getRallyCollectionName()}")
public class Defect {

    @JsonProperty("_ref")
    String ref;

    @JsonProperty("CreationDate")
    private Date creationDate;

    @Id
    @JsonProperty("ObjectID")
    private String defectID;

    @JsonProperty("Workspace")
    @Setter(AccessLevel.NONE)
    private String workspaceName;

    private String type = "Defect";

    public void setWorkspaceName(Object workspaceName) {
        if(workspaceName != null) this.workspaceName = (String) ((Map) workspaceName).get("_refObjectName");
    }

    @JsonProperty("CreatedBy")
    @Setter(AccessLevel.NONE)
    private String createdBy;

    public void setCreatedBy(Object createdBy) {
        if(createdBy!=null) this.createdBy = (String) ((Map) createdBy).get("_refObjectName");
    }

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Expedite")
    private Boolean expedite;

    @JsonProperty("FormattedID")
    private String formattedId;

    @JsonProperty("LastUpdateDate")
    private Date lastUpdateDate;

    @JsonProperty("Milestones")
    @Setter(AccessLevel.NONE)
    private Integer milestones;

    public void setMilestones(Object milestones) {
        if(milestones != null) this.milestones = ( (Integer) ((Map) milestones).get("Count"));
    }

    @JsonProperty("Name")
    private String name;

    @JsonProperty
    @Setter(AccessLevel.NONE)
    private String owner;

    public void setOwner(Object owner) {
        if(owner != null) this.owner = (String) ((Map) owner).get("_refObjectName");
    }

    @JsonProperty("Project")
    @Setter(AccessLevel.NONE)
    private String projectName;

    public void setProjectName(Object projectName) {
        if(projectName != null ) this.projectName = (String) ((Map) projectName).get("_refObjectName");
    }

    @JsonProperty("Ready")
    private Boolean ready;

    @JsonProperty("FlowState")
    @Setter(AccessLevel.NONE)
    private String flowState;

    public void setFlowState(Object flowState) {
        if(flowState!=null) this.flowState = (String) ((Map) flowState).get("_refObjectName");
    }

    @JsonProperty("FlowStateChangedDate")
    private Date flowStateChangedDate;

    @JsonProperty("LastBuild")
    private String lastBuild;

    @JsonProperty("LastRun")
    private Date lastRun;

    @JsonProperty("PassingTestCaseCount")
    private Integer passingTestCaseCount;

    @JsonProperty("ScheduleState")
    private String scheduleState;

    @JsonProperty("ScheduleStatePrefix")
    private String scheduleStatePrefix;

    @JsonProperty("TestCaseCount")
    private Integer testCaseCount;

    @JsonProperty("AcceptedDate")
    private Date acceptedDate;

    @JsonProperty("AffectsDoc")
    private Boolean acceptedDoc;

    @JsonProperty("Attachments")
    @Setter(AccessLevel.NONE)
    private Integer attachments;

    public void setAttachments(Object attachments) {
        if(attachments != null) this.attachments = (Integer) ((Map) attachments).get("Count");
    }

    @JsonProperty("Blocked")
    private Boolean blocked;

    @JsonProperty("BlockedReason")
    private String blockedReason;

    @JsonProperty("Blocker")
    @Setter(AccessLevel.NONE)
    private String blockerRef;

    public void setBlockerRef(Object blockerRef) {
        if(blockerRef != null) this.blockerRef = (String) ((Map) blockerRef).get("_ref");
    }

    @JsonProperty("ClosedDate")
    private Date closedDate;

    @JsonProperty("DefectSuites")
    @Setter(AccessLevel.NONE)
    private Integer defectSuites;

    public void setDefectSuites(Object defectSuites) {
        if(defectSuites != null) this.defectSuites =  (Integer) ((Map) defectSuites).get("Count");
    }

    @JsonProperty("Duplicates")
    @Setter(AccessLevel.NONE)
    private Integer duplicates;

    public void setDuplicates(Object duplicates) {
        if(duplicates != null) this.duplicates = (Integer) ((Map) duplicates).get("Count");
    }

    @JsonProperty("Environment")
    private String environment;

    @JsonProperty("FixedInBuild")
    private String fixedInBuild;

    @JsonProperty("FoundInBuild")
    private String foundInBuild;

    @JsonProperty("InProgressDate")
    private Date inProgressDate;

    @JsonProperty("Iteration")
    private Iteration iteration;

    @JsonProperty("OpenedDate")
    private Date openedDate;

    @JsonProperty("Package")
    private String packageInfo;

    @JsonProperty("PlanEstimate")
    private Double planEstimate;

    @JsonProperty("Priority")
    private String priority;

    @JsonProperty("Recycled")
    private Boolean recycled;

    @JsonProperty("Release")
    private Release release;

    @JsonProperty("Requirement")
    private UserStory requirement;

    @JsonProperty("Resolution")
    private String resolution;

    @JsonProperty("SalesforceCaseID")
    private String salesforceCaseID;

    @JsonProperty("salesforceCaseNumber")
    private String salesforceCaseNumber;

    @JsonProperty("Severity")
    private String severity;

    @JsonProperty("State")
    private String state;

    @JsonProperty("SubmittedBy")
    @Setter(AccessLevel.NONE)
    private String submittedBy;

    public void setSubmittedBy(Object submittedBy) {
        if(submittedBy!=null) this.submittedBy = (String) ((Map) submittedBy).get("_refObjectName");
    }

    @JsonProperty("TargetBuild")
    private String targetBuild;

    @JsonProperty("TargetDate")
    private Date targetDate;

    @JsonProperty("TaskActualTotal")
    private Integer taskActualTotal;

    @JsonProperty("TaskEstimateTotal")
    private Integer taskEstimateTotal;

    @JsonProperty("TaskRemainingTotal")
    private Integer taskRemainingTotal;

    @JsonProperty("TaskStatus")
    private String taskStatus;

    @JsonProperty("Tasks")
    @Setter(AccessLevel.NONE)
    private Integer tasks;

    public void setTasks(Object tasks) {
        if(tasks != null) this.tasks = (Integer) ((Map) tasks).get("Count");
    }

    @JsonProperty("TestCase")
    private TestCase testCase;

    @JsonProperty("TestCaseResult")
    @Setter(AccessLevel.NONE)
    private Execution testCaseResult;

    @JsonProperty("TestCaseStatus")
    private String TestCaseStatus;

    @JsonProperty("TestCases")
    @Setter(AccessLevel.NONE)
    private Integer testCases;

    public void setTestCases(Object testCases) {
        if(testCases != null) this.testCases = (Integer) ((Map) testCases).get("Count");
    }

    @JsonProperty("VerifiedInBuild")
    private String verifiedInBuild;

}
