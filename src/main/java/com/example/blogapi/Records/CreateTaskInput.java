package com.example.blogapi.Records;

import java.util.Date;

import com.example.blogapi.Entities.TaskStatusEnum;
import com.example.blogapi.Entities.Tasks;

public record CreateTaskInput(String name, String description, TaskStatusEnum status, Date dueDate) {
    public Tasks toTask() {
        Tasks task = new Tasks();

        task.setName(name);
        task.setDescription(description);
        task.setStatus(status);
        task.setDueDate(dueDate);
        return task;

    }

}
