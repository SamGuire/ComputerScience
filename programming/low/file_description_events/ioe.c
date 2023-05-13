#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
int main() {
    int file_fd = open("output.txt",O_CREAT | O_WRONLY);
    dup2(file_fd,1);
    printf("Hello from new output fd\n");
}