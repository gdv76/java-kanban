import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        try {
// Формируем список тестовых задач

            Task task1 = new Task(taskManager.getCounter(), "Просто задача 1", "просто описание задачи 1", TaskStatus.NEW);
            Task task2 = new Task(taskManager.getCounter(), "Просто задача 2", "просто описание задачи 2", TaskStatus.NEW);
            taskManager.addTask(task1);
            taskManager.addTask(task2);

            Epic epicFirst = new Epic(taskManager.getCounter(), "Эпик 1", "некоторое описание эпика 1");
            Task subTask1 = new Task(taskManager.getCounter(), "Подзадача 1", "Тестовый пример", TaskStatus.NEW);
            Task subTask2 = new Task(taskManager.getCounter(), "Подзадача 2", "Тестовый пример", TaskStatus.NEW);
            epicFirst.addSubTask(subTask1);
            epicFirst.addSubTask(subTask2);
            taskManager.addTask(epicFirst);

            Epic epicSecond = new Epic(taskManager.getCounter(), "Эпик 2", "некоторое описание эпика 1");
            Task subTask3 = new Task(taskManager.getCounter(), "Подзадача 1", "Тестовый пример", TaskStatus.NEW);
            epicSecond.addSubTask(subTask3);
            taskManager.addTask(epicSecond);

            Collection<Task> tasks = (Collection<Task>) taskManager.getTasks(null);

// Пример получения задач по типу - Epic
//            Collection<Epic> tasks = (Collection<Epic>) taskManager.getTasks(Epic.class);
//
//            for (Epic t : tasks) {
//                System.out.println("id = " + t.getId() + " title = " + t.getTitle() + " description =" + t.getDescription());
//                for (SubTask sb : t.getSubTasks()) {
//                    System.out.println("SubTask id = " + sb.getId() + " title = " + sb.getTitle() + " description =" + sb.getDescription());
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
            epicFirst.addSubTask(subTask1);
            taskManager.addTask(epicFirst);

            subTask3.setStatus(TaskStatus.DONE);
            epicSecond.addSubTask(subTask3);
            taskManager.addTask(epicSecond);

            tasks = (Collection<Task>) taskManager.getTasks(null);

            for(Task task: tasks) {
                System.out.println(task);
            }
            System.out.println('\n' + "Удаляем задачу и эпик после чего выводим список повторно:");
            taskManager.removeTaskById(1);
            taskManager.removeTaskById(6);

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
