import java.util.Collection;
import java.util.HashMap;

public class Epic extends Task{
    private HashMap<Integer,SubTask> subTasks;
    public Epic(Integer id, String title, String description) {
        super(id, title, description, TaskStatus.NEW);

        subTasks = new HashMap<>();

    }

    public void addSubTask(Task task) {
        subTasks.put(task.getId(), new SubTask(task,this));
    }
    public void addSubTask(SubTask subTask) {
        subTask.setEpic(this);
        subTasks.put(subTask.getId(),subTask);
    }

    public SubTask getSubTask(Integer subTaskId) {
        return subTasks.get(subTaskId);
    }

    public void removeSubTask(Integer subTaskId) {
        subTasks.remove(subTaskId);
    }
    public Collection<SubTask> getSubTasks() {
        return subTasks.values();
    }

    public TaskStatus getStatus() {
        TaskStatus epicStatus = TaskStatus.NEW;
        Boolean done = true;

        for(SubTask st : subTasks.values()) {
            if (st.getStatus() != TaskStatus.NEW) {
                epicStatus = TaskStatus.IN_PROGRESS;
            }
            done = done && (st.getStatus() == TaskStatus.DONE);
        }
        return done == true?TaskStatus.DONE:epicStatus;
    }

}
