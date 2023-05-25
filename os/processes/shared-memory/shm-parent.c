#include <stdlib.h>
#include <stdio.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
int main() {
	int SHM_SIZE = 4096;
	char * shm_name = "GLOBAL_AREA";
	char  msg_from_parent[] = "Hello World!\n";
	int msg_size = 13;
	int fd_shm = shm_open(shm_name,O_CREAT | O_RDWR,0666);
	void * ptr = ftruncate(fd_shm,SHM_SIZE);
	ptr = mmap(0,SHM_SIZE,PROT_WRITE,MAP_SHARED,fd_shm,0);
	for (int i= 0; i < msg_size; i++) {
	       	*(char *)ptr = msg_from_parent[i];
		ptr++;
	}
	return 0;	
}
