package org.tutucat.todoproject;

import java.util.List;

public class ToDo {
    public String taskName;
    public Boolean completed;

    public ToDo(String taskName, Boolean completed) {
        this.taskName = taskName;
        this.completed = completed;
    }

    public ToDo() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
