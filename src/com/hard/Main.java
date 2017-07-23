package com.hard;

import com.hard.controllers.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();

        new Thread(new Runnable() {
            @Override
            public void run() {
                taskController.runTasks(new int[] {1, 2, 3});
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                taskController.runTasks(new int[] {4, 5});
            }
        }).start();
    }
}
