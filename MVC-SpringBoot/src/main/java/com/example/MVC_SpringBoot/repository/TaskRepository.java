package com.example.MVC_SpringBoot.repository;

import com.example.MVC_SpringBoot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>
{
}
