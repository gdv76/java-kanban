import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TaskManager {
    private Integer counter = 0;
    private HashMap<Integer, Task> tasks;

    public TaskManager() {
        tasks = new HashMap<>();
    }

    public Integer getCounter() {
        return counter += 1;
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

// Получаем список задач по заданному классу.
// Если класс не задан (равен null), то возвращаем полный список задач

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

    public void removeAllTasks() {
        tasks.clear();
    }

    public void removeTaskById(Integer taskId) {
        tasks.remove(taskId);
    }

    public Task getTaskById(Integer taskId) {
        return tasks.get(taskId);
    }

    public Task UpdateTask(Task task) {
        return tasks.put(task.getId(), task);
    }
}
