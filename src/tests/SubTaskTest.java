package tests;

import model.SubTask;
import model.TaskStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubTaskTest {
    @Test
    void equalsSubTask() {
        SubTask subTask1 = new SubTask(11, "Title subtask 1", "Description subtask 1", TaskStatus.NEW, null);
        SubTask subTask2 = new SubTask(11, "Title subtask 2", "Description subtask 2", TaskStatus.NEW, null);
        assertEquals(subTask1, subTask2, "Подзадачи не совпадают.");
    }
}