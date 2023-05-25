#include <stdlib.h>
#include <stdio.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <sys/stat.h>

int main() {
	int SHM_SIZE = 4096;
	char * SHM_NAME = "GLOBAL_AREA";
	int fd_shm = shm_open(SHM_NAME,O_RDONLY,0666);
	void * ptr = mmap(0,SHM_SIZE,PROT_READ,MAP_SHARED,fd_shm,0);
	printf("%s",(char *) ptr);
	return 0;
}
