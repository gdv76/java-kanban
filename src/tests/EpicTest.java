package tests;

import model.Epic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EpicTest {
    @Test
    void equalsEpic() {
        Epic epic1 = new Epic(11, "Title epic 1", "Description epic 1");
        Epic epic2 = new Epic(11, "Title epic 2", "Description epic 2");
        assertEquals(epic1, epic2, "Эпики не совпадают.");
    }
    @Test
    void epicNotInjectToIntoYourself() {
        Epic epic = new Epic(11, "Title epic", "Description epic");
        assertNull(epic.addSubTask(epic), "Эпик добавляется в список собственных подзадач.");
    }
}