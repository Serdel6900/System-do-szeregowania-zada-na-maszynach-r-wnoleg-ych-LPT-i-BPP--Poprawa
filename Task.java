public class Task {
    private String name;
    private int duration;
    private int finishTime;

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.finishTime = 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return name + " (Duration: " + duration + ", Finish: " + finishTime + ")";
    }
}