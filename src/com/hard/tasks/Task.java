package com.hard.tasks;

import com.hard.utils.DateHelper;

public class Task {
    private String type;
    private long id;
    private int duration;
    private int priority;

    public Task() {

    }

    public Task(String type, long id, int duration, int priority) {
        this.type = type;
        this.id = id;
        this.duration = duration;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void execute() {
        System.out.println(DateHelper.getCurrentTime() + " start task " + this);
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(DateHelper.getCurrentTime() + " stop task " + this);
    }

    @Override
    public String toString() {
        return type
                + " (id: " + id
                + ", duration: " + duration
                + ", priority: " + priority
                + ")";
    }
}
