import java.util.Scanner;

class Task extends Thread {

    static long work;
    static volatile long result = 0;

    @Override
    public void run() {
        long sum = 0;

        for (long i = 0; i < work; i++) {
            sum += i;
        }

        result = sum; // Prevents the compiler from optimizing away the loop
    }
}

 class MultiThreading {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int n = sc.nextInt();

        System.out.print("Enter workload: ");
        Task.work = sc.nextLong();

        Thread[] threads = new Thread[n];

        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            threads[i] = new Task();
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads[i].join();
        }

        long end = System.currentTimeMillis();

        Runtime runtime = Runtime.getRuntime();

        System.out.println("\nMultithreading Completed");
        System.out.println("Execution Time: " + (end - start) + " ms");
        System.out.println("Memory Usage: "
                + (runtime.totalMemory() - runtime.freeMemory()) / 1024 + " KB");
    }
}