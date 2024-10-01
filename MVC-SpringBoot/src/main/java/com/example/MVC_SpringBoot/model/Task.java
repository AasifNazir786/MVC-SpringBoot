package com.example.MVC_SpringBoot.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    // @Override
    // public String toString() {
    //     return "Task{" +
    //             "id=" + id +
    //             ", name='" + name + '\'' +
    //             ", description='" + description + '\'' +
    //             ", dueDate=" + dueDate +
    //             ", status=" + status +
    //             ", project=" + project +
    //             '}';
    // }
}
enum TaskStatus
{
    PENDING, IN_PROGRESS, COMPLETED
}

