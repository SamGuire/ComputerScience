#include <stdio.h>
#include <stdlib.h>
int main() {
	int SIZE = 10000000;
	printf("Running program\n");
	int * values = malloc(SIZE*sizeof(int));
	for (int i = 0 ; i < SIZE; i++) values[i] = i;
	while (1) continue;
}
