package controllers;

import model.Task;

import java.util.Collection;
import java.util.List;

public interface TaskManager {
    Integer addTask(Task task);

    void removeTaskById(Integer taskId);

    Task getTaskById(Integer taskId);

    Task UpdateTask(Task task);

    List<Task> getHistory();

    public <T> Collection<?> getTasks(Class T);
}
