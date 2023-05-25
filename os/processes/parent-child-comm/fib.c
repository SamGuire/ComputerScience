#include <string.h>
#include <stdlib.h>
#include <stdio.h>
unsigned long long fib(int n) {
	if (n <= 1) return 1;
	return fib(n-1) + fib(n-2);
}
int main(int argc, char* argv[]) {
	int n = atoi(argv[1]);
	long long fib_v = fib(n);
	printf("Fib of %d -> %llu\n", n,fib_v);
	return 0;
}	
