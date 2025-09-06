import java.util.Comparator;
import java.util.List;

public class BPPScheduler {
    public static void schedule(List<Task> tasks, List<Machine> machines) {
        for (Task task : tasks) {
            Machine bestMachine = machines.stream()
                    .min(Comparator.comparingDouble(m -> (double) m.getLoad() / m.getPerformance()))
                    .get();
            bestMachine.addTask(task);
        }
    }
}