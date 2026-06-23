 class Worker {

    public static volatile long result = 0;

    public static void main(String[] args) {

        long work = Long.parseLong(args[0]);

        long sum = 0;

        for (long i = 0; i < work; i++) {
            sum += i;
        }

        result = sum; // Prevents optimization and removes warning
    }
}