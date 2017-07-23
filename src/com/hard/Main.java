package com.hard;

import com.hard.controllers.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.runTasks(new int[] {1, 2, 3});
        taskController.runTasks(new int[] {4, 5});
    }
}
