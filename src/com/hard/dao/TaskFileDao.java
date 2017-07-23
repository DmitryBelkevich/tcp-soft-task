package com.hard.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hard.tasks.Task;
import com.hard.utils.DateHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskFileDao {
    private String PATH = "resources";

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        for (File file : getFiles(PATH)) {
            Task task = null;
            try {
                task = mapper.readValue(file, Task.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            tasks.add(task);
        }

        return tasks;
    }

    public Task getTask(long id) {
        List<Task> tasks = getAllTasks();

        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println(DateHelper.getCurrentTime() + " receive task " + task);
                return task;
            }
        }

        return null;
    }

    public void addTask(Task task) {
        // TODO
    }

    public void removeTask(Task task) {
        // TODO
    }

    private List<File> getFiles(String path) {
        List<File> list = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && fileIsValid(file)) {
                list.add(file);
            }
        }

        return list;
    }

    private boolean fileIsValid(File file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readValue(file, Task.class);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
