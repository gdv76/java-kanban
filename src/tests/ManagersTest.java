package tests;

import controllers.TaskManager;
import model.Task;
import org.junit.jupiter.api.Test;
import utils.Managers;

import static model.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {

    @Test
    void getDefault() {
        TaskManager taskManager = Managers.getDefault();
        assertNotNull(taskManager, "Менеджер не создан");
        Task task = new Task(null, "Title task", "Description task", NEW);
        Integer id = taskManager.addTask(task);
        assertEquals(id, taskManager.getTaskById(id).getId(), "Не удалось получить добавленную задачу");
    }
}