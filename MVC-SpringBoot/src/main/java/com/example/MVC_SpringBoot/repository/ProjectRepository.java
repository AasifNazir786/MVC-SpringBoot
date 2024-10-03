package com.example.MVC_SpringBoot.repository;

import com.example.MVC_SpringBoot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>
{
}
