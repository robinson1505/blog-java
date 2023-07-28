package com.example.blogapi.Records;

import java.util.Date;

import com.example.blogapi.Entities.TaskStatusEnum;

public record UpdateTaskInput(TaskStatusEnum status, Date dueDate) {
    
}
