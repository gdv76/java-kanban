package controllers;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private static final Integer maxElementHistory = 10;

    private ArrayList<Task> history;

    public InMemoryHistoryManager() {
        this.history = new ArrayList<>();
    }

    @Override
    public void add(Task task) {
        if (task != null) {
            history.add(task);
            if (history.size() > maxElementHistory) {
                history.remove(0);
            }
        }
    }

    @Override
    public List<Task> getHistory() {
        ArrayList<Task> hist = new ArrayList<>();

        for (int i = history.size() - 1; i >= 0; i--) {
            hist.add(history.get(i));
        }
        return hist;
    }
}
