#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char* argv[]) {
	if (argc <= 1) {
		printf("Please supply fib executable file for child process\n");
		return 1;
	}
	printf("Child process will run executable -> %s\n",argv[1]);
	int p_id = fork();

	if (p_id < 0) {
		printf("Error forking");
		return 1;
	} else if (p_id == 0) {
		execlp(argv[1],"fib","45");
		return 0;
	}

	p_id = fork();
	if (p_id < 0) {
		printf("Error forking");
		return 1;
	} else if (p_id == 0) {
		execlp(argv[1],"fib","25");
		return 0;
	}
       
	p_id = fork();
	
	if (p_id < 0) {
		printf("Error forking");
		return 1;
	} else if (p_id == 0) {
		execlp(argv[1],"fib","10");
		return 0;
	}
	int child_pid;
	int status;
	while ((child_pid = wait(&status)) > 0) {
		printf("child %d has completed with status %d\n",child_pid,status);
	}
	return 0;
}
