#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int fib(int n) {
	if (n <= 1) return n;
	return fib(n-1) + fib(n-2);
}
void * worker_task(void * result ) {
	printf("'I am doing some work boss !' said thread %d\n",pthread_self());
	int fib_v = fib(45);
	int * result_computed = (int *) result;
	*result_computed=fib_v;
	pthread_exit(NULL);
}
	

int main() {
	printf("Starting thread showcase...\n");
	int NUM_OF_THREADS = 3;
	int worker_result[NUM_OF_THREADS];
	pthread_t threads[NUM_OF_THREADS];
	for (int i = 0; i < NUM_OF_THREADS;i++) pthread_create(&threads[i],NULL,worker_task,(void *)&worker_result[i]);
	for (int i = 0 ; i < NUM_OF_THREADS;i++) pthread_join(threads[i],NULL);
	
	printf("Back in main thread, let's see what our workers produced...\n");
	for (int i = 0 ; i < NUM_OF_THREADS; i++) printf("worker result #%d -> %d\n",i+1,worker_result[i]);
	return 0;
}
	
	
