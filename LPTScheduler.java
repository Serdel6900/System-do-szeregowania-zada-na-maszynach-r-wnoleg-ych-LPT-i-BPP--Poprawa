import java.util.Comparator;
import java.util.List;

public class LPTScheduler {
    public static void schedule(List<Task> tasks, List<Machine> machines) {
        tasks.sort((a, b) -> b.getDuration() - a.getDuration());
        for (Task task : tasks) {
            Machine minLoadMachine = machines.stream()
                    .min(Comparator.comparingInt(Machine::getLoad))
                    .get();
            minLoadMachine.addTask(task);
        }
    }
}