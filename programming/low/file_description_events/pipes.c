#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main() {
    int READIDX = 0; int WRITEIDX=1;
    int p[2];
    int is_sucessful = pipe(p);
    int MAX_SIZE = 1000;
    char buffer[MAX_SIZE];
    if (is_sucessful < 0) {
        printf("Error creating pipe...");
        return 0;
    }

    int process_id = fork();
    if (process_id == -1) {
        printf("Error creating child process...");
        return 0;
    } else if (process_id == 0) {
        //close(p[1]);
        read(p[0],buffer,MAX_SIZE);
        printf("msg from parent : %s\n", buffer);
        return 0;
    } else {
        //close(p[0]);
        char * msg = "Hello from parent\0";
        int n = strlen(msg);
        printf("Parent is writing msg of size %d\n",n);
        write(p[1],msg,n+1);
        return 0;
    }

    return 0;


}