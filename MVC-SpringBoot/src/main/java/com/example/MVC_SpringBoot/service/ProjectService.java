package com.example.MVC_SpringBoot.service;

import com.example.MVC_SpringBoot.model.Project;
import com.example.MVC_SpringBoot.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectService
{
    @Autowired
    private ProjectRepository repository;

    public List<Project> getAllProjects()
    {
        List<Project> projects = repository.findAll();
        return projects;
    }

    public Optional<Project> getProjectById(int id)
    {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project with id: " + id + " not found")));
  }

    public Project createProject(Project project)
    {
        return repository.save(project);
    }

    public Project updateProject(int id, Project project)
    {
        Project existingProject = repository.findById(id)
                .orElseThrow(()-> {
                    return new RuntimeException("Project with id: " + id + " not found");
                });
            existingProject.setId(project.getId());
            existingProject.setName(project.getName());
            existingProject.setTasks(project.getTasks());
            return repository.save(existingProject);
    }

    public void deleteProject(int id){
        Project project = repository.findById(id)
                .orElseThrow(()-> {
                    return new RuntimeException("Project with id: " + id + " not found");
                });
        repository.delete(project);
    }
}
