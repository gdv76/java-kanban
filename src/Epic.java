import java.util.HashMap;

public class Epic extends Task{
    private HashMap<Integer,SubTask> subTasks;
    public Epic(Integer id, String title, String description, TaskStatus status) {
        super(id, title, description, status);

        subTasks = new HashMap<>();


    }

    public void addSubTask(Task subTask) {

        subTasks.put(1,new SubTask(subTask,this));

    }

}
