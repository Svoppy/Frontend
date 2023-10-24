import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Process {
    String name;
    int arrivalTime;
    int burstTime;

    public Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Add processes (you can add more processes as needed)
        processes.add(new Process("P1", 0, 6));
        processes.add(new Process("P2", 2, 4));
        processes.add(new Process("P3", 4, 8));
        processes.add(new Process("P4", 6, 10));

        // Sort processes based on arrival time
        Collections.sort(processes, (p1, p2) -> p1.arrivalTime - p2.arrivalTime);

        int currentTime = 0;
        double totalTurnaroundTime = 0;
        double totalWaitingTime = 0;

        for (Process process : processes) {
            if (process.arrivalTime > currentTime) {
                currentTime = process.arrivalTime;
            }

            // Calculate waiting time for the current process
            int waitingTime = currentTime - process.arrivalTime;
            totalWaitingTime += waitingTime;

            // Calculate turnaround time for the current process
            int turnaroundTime = waitingTime + process.burstTime;
            totalTurnaroundTime += turnaroundTime;

            // Update current time
            currentTime += process.burstTime;

            System.out.println("Process " + process.name + ":");
            System.out.println("  Arrival Time: " + process.arrivalTime);
            System.out.println("  Burst Time: " + process.burstTime);
            System.out.println("  Waiting Time: " + waitingTime);
            System.out.println("  Turnaround Time: " + turnaroundTime);
        }

        double averageWaitingTime = totalWaitingTime / processes.size();
        double averageTurnaroundTime = totalTurnaroundTime / processes.size();

        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }
}
