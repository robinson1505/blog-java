package com.example.blogapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blogapi.Entities.Tasks;

@Repository
public interface TaskRepository extends CrudRepository<Tasks, UUID> {

}