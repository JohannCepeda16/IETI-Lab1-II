package edu.escuelaing.ieti.dto;

import java.io.Serializable;

import edu.escuelaing.ieti.helper.Status;

public class TaskDto implements Serializable{
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;
    private boolean created;

    public TaskDto() {
    }

    public TaskDto(String name, String description, Status status, String assignedTo, String dueDate, boolean created) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCreated() {
        return this.created;
    }

    public boolean getCreated() {
        return this.created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", assignedTo='" + getAssignedTo() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", created='" + isCreated() + "'" +
            "}";
    }
}
