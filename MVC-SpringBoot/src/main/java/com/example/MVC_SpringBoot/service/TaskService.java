package com.example.MVC_SpringBoot.service;

import com.example.MVC_SpringBoot.model.Task;
import com.example.MVC_SpringBoot.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskService
{
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll()
    {
        return repository.findAll();
    }

    public Task findById(int id)
    {
        Task task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("there is no task with id: "+ id));
        return task;
    }

    public Task createTask(Task task)
    {
        Task ta = repository.save(task);
        return ta;
    }

    public Task updateTask(int id, Task task)
    {
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no task with id: "+ id));
        if(existingTask != null)
        {
            existingTask.setName(task.getName());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setStatus(task.getStatus());
            existingTask.setProject(task.getProject());
            return repository.save(existingTask);
        }else
        {
            System.out.println("Can't update the task");
        }
        return null;
    }

    public void deleteTask(int id)
    {
        Task task = repository.findById(id).orElse(null);
        if(task != null){
            repository.delete(task);
        }else
        {
            throw new EntityNotFoundException("Task not found with id: " + id);
        }
    }
}
