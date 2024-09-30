package com.example.MVC_SpringBoot.repository;

import com.example.MVC_SpringBoot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
