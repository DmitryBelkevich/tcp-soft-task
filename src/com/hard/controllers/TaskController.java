package com.hard.controllers;

import com.hard.services.TaskService;
import com.hard.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private TaskService taskService = new TaskService();

    public void runTasks(int[] ids) {
        List<Task> tasks = new ArrayList<>();

        for (Integer id : ids) {
            tasks.add(taskService.getTask(id));
        }

        taskService.runTasks(tasks);
    }
}
