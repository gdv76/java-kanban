import java.util.Collection;
import java.util.HashMap;

public class TaskManager {
    private Integer counter;
    private HashMap<Integer,Task> tasks;

    public TaskManager() {
        tasks = new HashMap<>();
    }

    public Integer getCounter() {
        return counter += 1;
    }

    public void addTask(Task task) {
        tasks.put(task.getId(),task);
    }

    public Collection<Task> getTasks() {
        return tasks.values();
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
        return tasks.put(task.getId(),task);
    }

    public Collection<SubTask> getSubtaskByEpic(Epic epic) {
        return epic.getSubTasks();
    }

}
