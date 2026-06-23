#include <stdio.h>
#include <pthread.h>
#include <time.h>
#include <sys/resource.h>
long work;
void* task(void* arg) {
for(long i = 0; i < work; i++);
return NULL;
}
int main() {
int n;
printf("Enter number of threads: ");
scanf("%d", &n);
printf("Enter workload (iterations): ");
scanf("%ld", &work);
pthread_t threads[n];
clock_t start, end;
struct rusage usage;
start = clock();
for(int i = 0; i < n; i++) {
pthread_create(&threads[i], NULL, task, NULL);
}
for(int i = 0; i < n; i++) {
pthread_join(threads[i], NULL);
}
end = clock();
getrusage(RUSAGE_SELF, &usage);
double time_taken = (double)(end - start);
printf("\nMultithreading Execution Completed\n");
printf("Execution Time: %f seconds\n", time_taken);
printf("Memory Usage: %ld KB\n", usage.ru_maxrss);
return 0;
}