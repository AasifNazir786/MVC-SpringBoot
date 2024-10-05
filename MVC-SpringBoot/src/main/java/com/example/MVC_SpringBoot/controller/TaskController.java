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

import com.example.MVC_SpringBoot.model.Task;
import com.example.MVC_SpringBoot.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController
{
    @Autowired
    private TaskService service;

    @GetMapping
    public String getAllTasks(Model model){
        List<Task> tasks = service.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") int id, Model model){
        Task task = service.findById(id);
        model.addAttribute("task", task);
        return "edit-task";
    }

    @GetMapping("/new")
    public String showCreateTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping
    public String createTask(@ModelAttribute("task") Task task){
        service.createTask(task);
        return "redirect:/tasks";
    }
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") int id, @ModelAttribute("task") Task task) {
        service.updateTask(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        service.deleteTask(id);
        return "redirect:/tasks";
    }

}
