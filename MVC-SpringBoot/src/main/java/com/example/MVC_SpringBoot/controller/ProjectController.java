package com.example.MVC_SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MVC_SpringBoot.model.Project;
import com.example.MVC_SpringBoot.service.ProjectService;



@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping
    public String getAllProjects(Model model){
        List<Project> projects = service.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @PostMapping
    public String createProject(@ModelAttribute("project")Project project, Model model){
        model.addAttribute("project", project);
        return "redirect: projects";
    }

    @GetMapping("/new")
    public String showProjectForm(Model model){
        model.addAttribute("project", new Project());
        return "createProject";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id")int id, Model model){
        Project project = service.getProjectById(id).orElse(null);
        model.addAttribute("project", project);
        return "editProject";
    }

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute("project") Project project){
        service.updateProject(id, project);
        return "redirect:projects";
    }

    @PostMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") int id){
        service.deleteProject(id);
        return "redirect:projects";
    }
}
