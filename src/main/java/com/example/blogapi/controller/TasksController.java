package com.example.blogapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapi.Entities.Tasks;
import com.example.blogapi.Records.CreateTaskInput;
import com.example.blogapi.Records.UpdateTaskInput;
import com.example.blogapi.services.TaskService;

@RestController
public class TasksController {
    private TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Tasks> createTask(@RequestBody CreateTaskInput createTaskInput) {
        Tasks taskCreated = taskService.createTask(createTaskInput.toTask());
        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = taskService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Tasks> getTask(@PathVariable UUID id) {
        Optional<Tasks> task = taskService.findById(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable UUID id, @RequestBody UpdateTaskInput updateTaskInput) {
        Optional<Tasks> task = taskService.findById(id);
        if (task.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tasks taskToUpdate = task.get();
        taskToUpdate.setStatus(updateTaskInput.status());
        taskToUpdate.setDueDate(updateTaskInput.dueDate());

        Tasks taskUpdated = taskService.update(taskToUpdate);

        return new ResponseEntity<>(taskUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deteteTask(@PathVariable UUID id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}