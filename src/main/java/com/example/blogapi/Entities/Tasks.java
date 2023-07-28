package com.example.blogapi.Entities;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Table(name = "tasks")
@Entity
public class Tasks {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private UUID id;

  @Column(unique = true, length = 200, nullable = false)
  private String name;

  @Lob
  private String description;

  @Column(nullable = false, columnDefinition = "varchar(20) not null default 'PENDING'")
  @Enumerated(EnumType.STRING)
  private TaskStatusEnum status;

  @Column(name="due_date")
  private Date dueDate;
 
  @CreationTimestamp
  @Column(updatable = false,name="created_at")
  private Date createdAt;

  @UpdateTimestamp
  @Column(name="update_at")
  private Date updateAt;






  // get the id and set the id
  public UUID getId() {
    return id;
  }

  public UUID setId(UUID id) {
    return this.id = id;
  }

  // get and set the name of the user
  public String getName() {
    return name;
  }
  public String setName(String name) {
    return this.name = name;
  }

  // DESCRIPTION
  public String getDescripton() {
    return description;
  }

  public String setDescription(String description) {
    return this.description = description;
  }

  public TaskStatusEnum getTaskStatus(){
    return status;
  }
  
  public TaskStatusEnum setStatus(TaskStatusEnum status) {
    return this.status = status;
  }

   public Date getDueDate(){
    return dueDate;
  }
  
  public Date setDueDate(Date dueDate) {
    return this.dueDate= dueDate;
  }



}
