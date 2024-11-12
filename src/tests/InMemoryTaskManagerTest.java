package tests;

import controllers.InMemoryTaskManager;
import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskStatus;
import org.junit.jupiter.api.Test;

import static model.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    @Test
    void addTaskToListAndGet() {
        InMemoryTaskManager taskManager = new InMemoryTaskManager();
        assertNotNull(taskManager, "Менеджер не создан");

        Task task = new Task(12, "Title task", "Description task", NEW);
        Epic epic = new Epic(11, "Title epic", "Description epic");
        SubTask subTask = new SubTask(null, "Подзадача", "Тестовый пример подзадачи", TaskStatus.NEW,epic);
        Integer taskId = taskManager.addTask(task);
        assertEquals(taskId, taskManager.getTaskById(taskId).getId(), "Не удалось получить добавленную задачу");

        Integer epicId = taskManager.addTask(epic);
        assertEquals(epicId, taskManager.getTaskById(epicId).getId(), "Не удалось получить добавленный эпик");

        Integer subtaskId = taskManager.addTask(subTask);
        Epic epicInTaskManager = (Epic)(taskManager.getTaskById(epicId));
        assertEquals(subtaskId, epicInTaskManager.getSubTask(subtaskId).getId(), "Не удалось получить добавленную подзадачу");
    }
}