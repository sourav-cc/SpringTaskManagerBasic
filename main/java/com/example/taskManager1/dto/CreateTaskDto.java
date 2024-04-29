package com.example.taskManager1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskDto {
    String title;
    String description;
    String deadline;
}
