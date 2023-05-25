#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
int main() {
	char buffer[10000];
	int READ = 0;
	int WRITE = 1;
	int fd[2];
	int status = pipe(fd);
	if (status < 0) {
		printf("Error creating pipe\n");
		return 1;
	}

	int p_id = fork();
	if (p_id < 0) {
		printf("Error forking\n");
		return 1;
	} else if (p_id == 0) {
		int n_bytes;
		close(fd[WRITE]);
		while ((n_bytes = read(fd[READ],buffer,10000)) > 0) {
			printf("Message from parent -> %s\n",buffer);
		}
		close(fd[READ]);
		printf("Parent has stopped sending\n");
		return 0;
	} else {
		close(fd[READ]);
		write(fd[WRITE],"Hello from parent",17);
		close(fd[WRITE]);
		wait(NULL);
		printf("Child process exited\n");
		return 0;
	}
}

