package tests;

import controllers.InMemoryHistoryManager;
import model.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.TaskStatus.DONE;
import static model.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
//    убеждаемся, что задачи, добавляемые в HistoryManager, сохраняют предыдущую версию задачи и её данных.
    @Test
    void checkTaskInHistory() {
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();

        Task task = new Task(11, "Title task", "Description task", NEW);
        inMemoryHistoryManager.add(task);
        task.setStatus(DONE);
        inMemoryHistoryManager.add(task);

        List<Task> hist = inMemoryHistoryManager.getHistory();

        assertEquals(task.getId(),hist.get(1).getId(), "ID задач не совпадает");
        assertEquals(task.getTitle(),hist.get(1).getTitle(), "Заголовок задач не совпадает");
        assertEquals(task.getDescription(),hist.get(1).getDescription(), "Описание задач не совпадает");
        assertEquals(NEW,hist.get(1).getStatus(), "Статус задач не совпадает");

        assertEquals(task.getId(),hist.get(0).getId(), "ID измененной задачи не совпадает");
        assertEquals(task.getTitle(),hist.get(0).getTitle(), "Заголовок измененной задачи не совпадает");
        assertEquals(task.getDescription(),hist.get(0).getDescription(), "Описание измененной задачи не совпадает");
        assertEquals(DONE,hist.get(0).getStatus(), "Статус измененной задачи не совпадает");
    }

}