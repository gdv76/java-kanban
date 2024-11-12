package model;

import java.util.Collection;
import java.util.HashMap;

public class Epic extends Task {
    private HashMap<Integer, SubTask> subTasks;

    public Epic(Integer id, String title, String description) {
        super(id, title, description, null);

        subTasks = new HashMap<>();

    }

// Вначале для методом ниже, делал обработку ситуации если task = null через try-catch и выбросом NullPointerException
// , но т.к выброс исключения будет в любом случае - убрал

    public Integer addSubTask(Task task) {
        if (task instanceof SubTask) {
            subTasks.put(task.getId(), new SubTask(task, this));
            return task.getId();
        }
        return null;
    }

    public Integer addSubTask(SubTask subTask) {
        if (subTask != null && subTask.getId() != null) {
            subTask.setEpic(this);
            subTasks.put(subTask.getId(), subTask);
            return subTask.getId();
        }
        return null;
    }

    public SubTask getSubTask(Integer subTaskId) {
        if (subTaskId != null) {
            return subTasks.get(subTaskId);
        }
        return null;
    }

    public void removeAllSubTask() {
        subTasks.clear();
    }

    public void removeSubTask(Integer subTaskId) {
        subTasks.remove(subTaskId);
    }

    public Collection<SubTask> getSubTasks() {
        return subTasks.values();
    }

    // Заглушка. Статус эпика пользователь не может поменять.
    public void setStatus(TaskStatus status) {
    }

    // Рассчитываем статус эпика
    public TaskStatus getStatus() {
        TaskStatus epicStatus = TaskStatus.NEW;
        Boolean done = true;

        for (SubTask st : subTasks.values()) {
            if (st.getStatus() != TaskStatus.NEW) {
                epicStatus = TaskStatus.IN_PROGRESS;
            }
            done = done && (st.getStatus() == TaskStatus.DONE);
        }
        return subTasks.values().size() > 0 && done == true ? TaskStatus.DONE : epicStatus;
    }

    @Override
    public String toString() {
        String infoByEpic = super.toString();

        for(SubTask sb: subTasks.values()) {
            infoByEpic = infoByEpic + '\n' + sb.toString();
        }
        return infoByEpic;
    }
}
