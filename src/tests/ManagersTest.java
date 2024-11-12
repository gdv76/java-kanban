package tests;

import controllers.TaskManager;
import model.Task;
import model.TaskStatus;
import org.junit.jupiter.api.Test;
import utils.Managers;

import static model.TaskStatus.DONE;
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

    @Test
    void taskUniqID() {
        TaskManager taskManager = Managers.getDefault();
        assertNotNull(taskManager, "Менеджер не создан");
        Task task1 = new Task(23, "Title task1", "Description task1", NEW);
        Task task2 = new Task(23, "Title task2", "Description task2", NEW);

        Integer idTask1 = taskManager.addTask(task1);
        Integer idTask2 = taskManager.addTask(task2);
        assertNotEquals(idTask1,idTask2, "ID задач не уникальны");
    }

    @Test
    void taskEquals() {
        TaskManager taskManager = Managers.getDefault();
        assertNotNull(taskManager, "Менеджер не создан");
        Task task = new Task(23, "Title task", "Description task", DONE);

        Integer idTask = taskManager.addTask(task);
        Task taskOnManager = taskManager.getTaskById(idTask);

        assertEquals(task.getTitle(),taskOnManager.getTitle(), "Заголовок задач не совпадает");
        assertEquals(task.getDescription(),taskOnManager.getDescription(), "Описание задач не совпадает");
        assertEquals(task.getStatus(),taskOnManager.getStatus(), "Статус задач не совпадает");
    }

}