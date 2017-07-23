package com.hard.services;

import com.hard.dao.TaskFileDao;
import com.hard.tasks.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private TaskFileDao dao = new TaskFileDao();

    public List<Task> getAllTasks() {
        return dao.getAllTasks();
    }

    public Task getTask(int id) {
        return dao.getTask(id);
    }

    public void addTask(Task task) {
        dao.addTask(task);
    }

    public void removeTask(Task task) {
        dao.removeTask(task);
    }

    public void runTasks(List<Task> tasks) {
        Comparator<Task> comparator = new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                return task1.getPriority() - task2.getPriority();
            }
        };

        Collections.sort(tasks, comparator);

        for (Task task : tasks) {
            task.execute();

            // этот sleep только лишь для наглядности того, чтобы увидеть, что таски запускаются в отортированном по приоритету виде
            // данную конструкцию можно убрать
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
