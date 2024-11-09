package controllers;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TaskManager {
    private Integer counter = 0;
    private HashMap<Integer, Task> tasks;
    private Class T;

    public TaskManager() {
        tasks = new HashMap<>();
    }

    public Integer getCounter() {
        return counter += 1;
    }

    // Поправил реализацию в соответствии с замечанием
    // p.s делал проброс id задачи т.к в ТЗ не было условия именно такой реализации
    public Integer addTask(Task task) {
        Integer id = task.getId();

// Если это сабтаска то поверяем что для нее есть эпик и добавляем к подзадачам эпика
        if (task instanceof SubTask) {
            SubTask subTask = (SubTask)task;
            Epic epic = subTask.getEpic();
            if (epic == null) {
                return null;
            }
            if (id == null || epic.getSubTask(id) == null) {
                id = getCounter();
                task.setId(id);
            }
            epic.addSubTask(task);
            return id;
        }
// Сделал проверку на null и наличие id в мапе что бы при каждой перезаписи задачи в мапе, не генерировался новый Id
// сделал Integer а не int т.к при null падает exception
        if (id == null || !tasks.containsKey(id)) {
            id = getCounter();
            task.setId(id);
        }
        tasks.put(id, task);
        return id;
    }

// Получаем список задач по заданному классу.
// Если класс не задан (равен null), то возвращаем полный список задач
// При не верном классе возвращается пустая коллекция

    public <T> Collection<?> getTasks(Class T) {
        if (T == null) {
            return tasks.values();
        }
        Collection<T> resultValues = new ArrayList<T>();
        for (Task task : tasks.values()) {
            if (task.getClass() == T) {
                resultValues.add((T) task);
            }
        }

        return resultValues;
    }

// Если аргумент NULL, то удаляем все задачи из менеджера задач
    public <T> void removeAllTasks(Class T) {
        if (T == null) {
            tasks.clear();
            return;
        }
        for(Task t: tasks.values()) {
            if (t.getClass() == T) {
                tasks.remove(t.getId());
            }
        }
    }

// Если задача- Эпик, то дополнительно удаляем все подзадачи
// Удаление отдельно подзадачи кажется не имеет смысл т.к она часть эпика и в списке менеджера задач не может
// находиться вне эпика
    public void removeTaskById(Integer taskId) {
        Task task = tasks.get(taskId);
        if (task != null && task instanceof Epic) {
           Epic epic = (Epic) task;
           epic.removeAllSubTask();
        }
        tasks.remove(taskId);
    }

    public Task getTaskById(Integer taskId) {
        return tasks.get(taskId);
    }

    public Task UpdateTask(Task task) {
        return tasks.put(task.getId(), task);
    }
}
