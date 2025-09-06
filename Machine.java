import java.util.ArrayList;
import java.util.List;

public class Machine {
    private String name;
    private int performance;
    private int load;
    private List<Task> tasks;

    public Machine(String name, int performance) {
        this.name = name;
        this.performance = performance;
        this.load = 0;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        load += task.getDuration();
        task.setFinishTime(load);
        tasks.add(task);
    }

    public String getName() {
        return name;
    }

    public int getPerformance() {
        return performance;
    }

    public int getLoad() {
        return load;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return name + " (Load: " + load + ") Tasks: " + tasks.stream().map(Task::getName).toList();
    }
}