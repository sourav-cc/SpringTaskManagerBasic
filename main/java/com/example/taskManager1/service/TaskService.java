package com.example.taskManager1.service;

import com.example.taskManager1.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskId);
        taskEntity.setTitle(title);
        taskEntity.setDescription(description);
/*        taskEntity.setDeadline(new Date(deadline));*/
        taskEntity.setCompleted(false);
        tasks.add(taskEntity);
        taskId++;
        return taskEntity;
    }

   public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

   public TaskEntity getTaskByEntity(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
