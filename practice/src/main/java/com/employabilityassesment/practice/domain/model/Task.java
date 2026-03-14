package com.employabilityassesment.practice.domain.model;

import java.util.UUID;

public class Task {
    private UUID taskId;
    private UUID projectId;
    private String taskTitle;
    private boolean isCompleted;
    private boolean isDeleted;

    public Task() {
    }

    public Task(UUID taskId, UUID projectId, String taskTitle) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.taskTitle = taskTitle;
        this.isCompleted = false;
        this.isDeleted = false;
    }


    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
