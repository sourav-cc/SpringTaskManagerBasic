package com.example.taskManager1.controllers;

import com.example.taskManager1.dto.CreateTaskDto;
import com.example.taskManager1.entities.TaskEntity;
import com.example.taskManager1.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){
        var task = taskService.getTaskByEntity(id);
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDto createTaskDto){
        var task = taskService.addTask(createTaskDto.getTitle(),createTaskDto.getDescription(),createTaskDto.getDeadline());
        return ResponseEntity.ok(task);
    }

}
