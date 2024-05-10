package com.cognizant.collector.rally.beans.userstory;

import com.cognizant.collector.rally.beans.common.*;
import com.cognizant.collector.rally.beans.iteration.*;
import com.cognizant.collector.rally.beans.release.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Data
@Document(collection = "#{T(com.cognizant.collector.rally.component.CommonUtilComponent).getRallyCollectionName()}")
public class UserStory {

    @Id
    @JsonProperty("ObjectID")
    private String userStoryID;

    @JsonProperty("Name")
    @JsonAlias("_refObjectName")
    private String name;

    @JsonProperty("_ref")
    private String ref;

    private String type = "User Story";

    @JsonProperty("CreationDate")
    private Date creationDate;

    @JsonProperty("Workspace")
    @Setter(AccessLevel.NONE)
    private String workspaceName;

    public void setWorkspaceName(Map<String, String> workspaceName) {
        if(workspaceName != null) this.workspaceName = workspaceName.get("_refObjectName");
    }

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
    public String formattedId;

    @JsonProperty("LastUpdateDate")
    private Date lastUpdateDate;

    @JsonProperty("Milestones")
    @Setter(AccessLevel.NONE)
    private Integer milestones;

    public void setMilestones(Object milestones) {
        if(milestones != null) this.milestones = ( (Integer) ((Map) milestones).get("Count"));
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

    @JsonProperty("Attachments")
    @Setter(AccessLevel.NONE)
    private Integer attachments;

    public void setAttachments(Object attachments) {
        if(attachments != null) this.attachments = (Integer) ((Map) attachments).get("Count");
    }

    @JsonProperty("Package")
    private String packageInfo;

    @JsonProperty("AcceptedDate")
    private Date acceptedDate;

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

    @JsonProperty("Children")
    @Setter(AccessLevel.NONE)
    private Integer children;

    public void setChildren(Object children) {
        if(children != null) this.children = (Integer) ((Map)children).get("Count");
    }

    @JsonProperty("DefectStatus")
    private String defectStatus;

    @JsonProperty("Defects")
    @Setter(AccessLevel.NONE)
    private Integer defects;

    public void setDefects(Object defects) {
        if(defects != null) this.defects = (Integer) ((Map) defects).get("Count");
    }

    @JsonProperty("DirectChildrenCount")
    private Integer directChildrenCount;

    @JsonProperty("DirectPassingTestCaseCount")
    private Integer directPassingTestCaseCount;

    @JsonProperty("HasParent")
    private Boolean hasParent;

    @JsonProperty("InProgressDate")
    private Date inProgressDate;

    @JsonProperty("Iteration")
    private Iteration iteration;

    @JsonProperty("Parent")
    private UserStory parent;

    @JsonProperty("PlanEstimate")
    private Double planEstimate;

    @JsonProperty("Predecessors")
    @Setter(AccessLevel.NONE)
    private Integer predecessors;

    public void setPredecessors(Object predecessors) {
        if(predecessors != null) this.predecessors = (Integer) ((Map)predecessors).get("Count");
    }

    @JsonProperty("Recycled")
    private Boolean recycled;

    @JsonProperty("Release")
    private Release release;

    @JsonProperty("Risks")
    @Setter(AccessLevel.NONE)
    private Integer risks;

    public void setRisks(Object risks) {
        if(risks != null) this.risks = (Integer) ((Map) risks).get("Count");
    }

    @JsonProperty("Successors")
    @Setter(AccessLevel.NONE)
    private Integer successors;

    public void setSuccessors(Object successors) {
        if(successors != null) this.successors = (Integer) ((Map) successors).get("Count");
    }

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

    @JsonProperty("TestCaseStatus")
    private String testCaseStatus;

    @JsonProperty("TestCases")
    @Setter(AccessLevel.NONE)
    private Integer testCases;

    public void setTestCases(Object testCases) {
        if(testCases != null) this.testCases = (Integer) ((Map) testCases).get("Count");
    }

    @JsonProperty("TotalDirectTestCaseCount")
    private Integer totalDirectTestCaseCount;

    @JsonProperty("PortfolioItem")
    private PortfolioItemDetails portfolioItem;

}
