#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>
#include <sys/resource.h>

long work;

void task() {
    volatile long dummy = 0;

    for (long i = 0; i < work; i++) {
        dummy += i;
    }
}

int main() {
    int n;
    struct timespec start, end;
    struct rusage usage;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    printf("Enter workload (iterations): ");
    scanf("%ld", &work);

    clock_gettime(CLOCK_MONOTONIC, &start);

    for (int i = 0; i < n; i++) {
        pid_t pid = fork();

        if (pid < 0) {
            perror("fork failed");
            return 1;
        }

        if (pid == 0) {
            task();
            return 0;
        }
    }

    for (int i = 0; i < n; i++) {
        wait(NULL);
    }

    clock_gettime(CLOCK_MONOTONIC, &end);

    getrusage(RUSAGE_SELF, &usage);

    double time_taken =
        (end.tv_sec - start.tv_sec) +
        (end.tv_nsec - start.tv_nsec) / 1e9;

    printf("\nMultiprocessing Execution Completed\n");
    printf("Execution Time: %.6f seconds\n", time_taken);
    printf("Memory Usage: %ld KB\n", usage.ru_maxrss);

    return 0;
}