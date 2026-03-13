package com.employabilityassesment.practice.domain.model;

import java.util.UUID;

public class Project {
    private UUID projectId;
    private UUID ownerId;
    private String projectName;
    private ProjectStatus projectStatus;
    private boolean isDeleted;

    public Project () {}

    public Project (UUID projectId,UUID ownerId, String projectName){
        this.projectId = projectId;
        this.ownerId = ownerId;
        this.projectName = projectName;
        this.projectStatus = ProjectStatus.DRAFT;
        this.isDeleted = false;
    }


    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
