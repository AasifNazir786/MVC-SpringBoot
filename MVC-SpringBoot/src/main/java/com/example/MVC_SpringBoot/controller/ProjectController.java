package com.example.MVC_SpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MVC_SpringBoot.model.Project;
import com.example.MVC_SpringBoot.model.Task;
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
    public String createProject(@ModelAttribute("project") Project project, @RequestParam("tasksInput") String tasksInput) {
        // Convert tasks string (comma-separated) to Task objects
        List<Task> taskList = new ArrayList<>();
        if (tasksInput != null && !tasksInput.isEmpty()) {
            String[] taskArray = tasksInput.split(",");
            for (String taskName : taskArray) {
                Task task = new Task();
                task.setName(taskName.trim());
                task.setProject(project);
                taskList.add(task);
            }
        }
        project.setTasks(taskList);
        service.createProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/new")
    public String showProjectForm(Model model){
        model.addAttribute("project", new Project());
        return "create-project";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id")int id, Model model){
        Project project = service.getProjectById(id).orElse(null);
        model.addAttribute("project", project);
        return "edit-project";
    }

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute("project") Project project){
        service.updateProject(id, project);
        return "redirect:/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") int id){
        service.deleteProject(id);
        return "redirect:/projects";
    }
}
