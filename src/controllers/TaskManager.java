package controllers;

import model.Task;

public interface TaskManager {
    Integer addTask(Task task);
    void removeTaskById(Integer taskId);

    Task getTaskById(Integer taskId);

    Task UpdateTask(Task task);
}
