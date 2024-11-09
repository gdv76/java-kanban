import controllers.TaskManager;
import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskStatus;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        try {
// Формируем список тестовых задач

            Task task1 = new Task(null, "Просто задача 1", "просто описание задачи 1", TaskStatus.NEW);
            Task task2 = new Task(null, "Просто задача 2", "просто описание задачи 2", TaskStatus.NEW);
            taskManager.addTask(task1);
            taskManager.addTask(task2);

            Epic epicFirst = new Epic(null, "Эпик 1", "некоторое описание эпика 1");
            taskManager.addTask(epicFirst);

            SubTask subTask1 = new SubTask(null, "Подзадача 1", "Тестовый пример", TaskStatus.NEW,epicFirst);
            SubTask subTask2 = new SubTask(null, "Подзадача 2", "Тестовый пример", TaskStatus.NEW,epicFirst);
            taskManager.addTask(subTask1);
            taskManager.addTask(subTask2);

            Epic epicSecond = new Epic(null, "Эпик 2", "некоторое описание эпика 1");
            taskManager.addTask(epicSecond);

            SubTask subTask3 = new SubTask(null, "Подзадача 1", "Тестовый пример", TaskStatus.NEW,epicSecond);
            taskManager.addTask(subTask3);

            Collection<Task> tasks = (Collection<Task>) taskManager.getTasks(null);

// Пример получения задач по типу - model.Epic
//            Collection<model.Epic> tasks = (Collection<model.Epic>) taskManager.getTasks(model.Epic.class);
//
//            for (model.Epic t : tasks) {
//                System.out.println("id = " + t.getId() + " title = " + t.getTitle() + " description =" + t.getDescription());
//                for (model.SubTask sb : t.getSubTasks()) {
//                    System.out.println("model.SubTask id = " + sb.getId() + " title = " + sb.getTitle() + " description =" + sb.getDescription());
//                }
//            }
            for(Task task: tasks) {
                System.out.println(task);
            }

            System.out.println('\n' + "Меняем статус задач и подзадач и выводим список повторно:");
            task1.setStatus(TaskStatus.IN_PROGRESS);
            taskManager.addTask(task1);
            task2.setStatus(TaskStatus.DONE);
            taskManager.addTask(task2);

            epicFirst.setStatus(TaskStatus.DONE);

            subTask1.setStatus(TaskStatus.IN_PROGRESS);
            taskManager.addTask(subTask1);

            subTask3.setStatus(TaskStatus.DONE);
            taskManager.addTask(subTask3);

            tasks = (Collection<Task>) taskManager.getTasks(null);

            for(Task task: tasks) {
                System.out.println(task);
            }
            System.out.println('\n' + "Удаляем задачу и эпик после чего выводим список повторно:");
            taskManager.removeTaskById(1);
            System.out.println(epicSecond);
            taskManager.removeTaskById(6);
            System.out.println(epicSecond);

            tasks = (Collection<Task>) taskManager.getTasks(null);

            for(Task task: tasks) {
                System.out.println(task);
            }

        } catch (Exception ex) {
            System.out.println("Не корректные данные! ");
            System.out.println(ex.getMessage());
        }
    }
}
