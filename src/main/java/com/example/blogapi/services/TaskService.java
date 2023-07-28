package com.example.blogapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.blogapi.Entities.Tasks;
import com.example.blogapi.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Tasks createTask(Tasks task) {
        return this.taskRepository.save(task);
    }

    public List<Tasks> findAllTasks() {
        List<Tasks> tasks = new ArrayList<>();
        this.taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Optional<Tasks> findById(UUID id) {
        return this.taskRepository.findById(id);
    }

    public Tasks update(Tasks taskToUpdate) {
        return taskRepository.save(taskToUpdate);
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

}
