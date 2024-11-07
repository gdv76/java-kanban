import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        Epic epic = new Epic(taskManager.getCounter(), "Тестовый эпик", "некоторое описание");
        epic.addSubTask(new Task(taskManager.getCounter(), "Подзадача 1", "Тестовый пример", TaskStatus.NEW));
        taskManager.addTask(epic);

        Task task = new Task(taskManager.getCounter(), "Просто задача", "просто описание задачи", TaskStatus.NEW);
        taskManager.addTask(task);

        Collection<Epic> tasks = (Collection<Epic>) taskManager.getTasks(Epic.class);

        for (Epic t : tasks) {
            System.out.println("id = " + t.getId() + " title = " + t.getTitle() + " description =" + t.getDescription());
            for (SubTask sb : t.getSubTasks()) {
                System.out.println("SubTask id = " + sb.getId() + " title = " + sb.getTitle() + " description =" + sb.getDescription());
            }
        }
        System.out.println("Приехали!");

    }
}
