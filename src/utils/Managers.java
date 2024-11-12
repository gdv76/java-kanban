package utils;

import controllers.InMemoryTaskManager;
import controllers.TaskManager;

public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }
}
