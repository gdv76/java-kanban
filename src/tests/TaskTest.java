package tests;

import model.Task;
import org.junit.jupiter.api.Test;

import static model.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void equalsTask() {
// По ТЗ две задачи равны если их ID равны, метод equals проверяет только равенство ID
        Task task1 = new Task(11, "Title task 1", "Description task 1", NEW);
        Task task2 = new Task(11, "Title task 2", "Description task 2", NEW);
        assertEquals(task1, task2, "Задачи не совпадают.");
    }

}