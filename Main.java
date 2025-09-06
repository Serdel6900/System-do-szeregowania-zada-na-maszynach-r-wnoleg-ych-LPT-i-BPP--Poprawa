import java.util.*;

public class Main {

    public static double averageFlowTime(List<Machine> machines) {
        int totalFinishTime = 0;
        int totalTasks = 0;
        for (Machine m : machines) {
            for (Task t : m.getTasks()) {
                totalFinishTime += t.getFinishTime();
                totalTasks++;
            }
        }
        return totalTasks == 0 ? 0 : (double) totalFinishTime / totalTasks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę maszyn: ");
        int numMachines = scanner.nextInt();
        List<Machine> machinesLPT = new ArrayList<>();
        List<Machine> machinesBPP = new ArrayList<>();
        for (int i = 1; i <= numMachines; i++) {
            System.out.print("Podaj wydajność maszyny " + i + ": ");
            int perf = scanner.nextInt();
            machinesLPT.add(new Machine("Maszyna" + i, perf));
            machinesBPP.add(new Machine("Maszyna" + i, perf));
        }

        System.out.print("Podaj liczbę zadań: ");
        int numTasks = scanner.nextInt();
        scanner.nextLine();
        List<Task> tasks = new ArrayList<>();
        for (int i = 1; i <= numTasks; i++) {
            System.out.print("Podaj nazwę zadania " + i + ": ");
            String name = scanner.nextLine();
            System.out.print("Podaj czas wykonania zadania " + i + ": ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            tasks.add(new Task(name, duration));
        }

        System.out.println("\n=== LPT Scheduler ===");
        LPTScheduler.schedule(tasks, machinesLPT);
        machinesLPT.forEach(System.out::println);
        int makespanLPT = machinesLPT.stream().mapToInt(Machine::getLoad).max().getAsInt();
        System.out.println("Makespan: " + makespanLPT);
        System.out.println("Średni czas przepływu: " + averageFlowTime(machinesLPT));

        // reset finishTime dla zadań przed BPP
        tasks.forEach(t -> t.setFinishTime(0));

        System.out.println("\n=== BPP Scheduler ===");
        BPPScheduler.schedule(tasks, machinesBPP);
        machinesBPP.forEach(System.out::println);
        int makespanBPP = machinesBPP.stream().mapToInt(Machine::getLoad).max().getAsInt();
        System.out.println("Makespan: " + makespanBPP);
        System.out.println("Średni czas przepływu: " + averageFlowTime(machinesBPP));

        scanner.close();
    }
}