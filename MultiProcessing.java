import java.util.*;
//import java.io.*;

public class MultiProcessing {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter workload: ");
        long work = sc.nextLong();

        List<Process> processes = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "Worker",
                    String.valueOf(work));

            pb.inheritIO();

            processes.add(pb.start());
        }

        for (Process p : processes) {
            p.waitFor();
        }

        long end = System.currentTimeMillis();

        System.out.println("\nMultiprocessing Completed");
        System.out.println("Execution Time: " + (end - start) + " ms");

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memory = (runtime.totalMemory() - runtime.freeMemory()) / 1024;

        System.out.println("Memory Usage: " + memory + " KB");

        sc.close();
    }
}