package model;

public class SubTask extends Task {
    private Epic epic;

    public SubTask(Integer id, String title, String description, TaskStatus status, Epic epic) {
        super(id, title, description, status);
        this.epic = epic;
    }

    public SubTask(Task task, Epic epic) {
        super(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
        this.epic = epic;
    }


    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public SubTask clone() {
        SubTask subTask = new SubTask(this.getId(), this.getTitle(), this.getDescription(), this.getStatus(), epic);

        return subTask;
    }

    @Override
    public String toString() {
        return super.toString() + " - for epic with id = " + epic.getId() + " ";
    }
}
