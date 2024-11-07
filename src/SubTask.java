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
}
