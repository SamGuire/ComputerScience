#include <sys/epoll.h>
#include <stdio.h>
#include <unistd.h>
int main() {
    int MAX_NUMBER_OF_EVENTS_TO_PROCESS = 5;
    int MAX_NUMBER_OF_BYTES = 1;
    char buffer[MAX_NUMBER_OF_BYTES];
    struct epoll_event event, events_ready[MAX_NUMBER_OF_EVENTS_TO_PROCESS];

    // Initialize event pool
    int epoll_fd = epoll_create1(0);
    if (epoll_fd == -1) {
        printf("Error has occured when creating epoll %s",stderr);
        return 1;
    }

    // create an event to watch
    event.data.fd = 0;
    event.events = EPOLLIN; // watch for read ready data in stdin (fd = 0)

    int successful_add = epoll_ctl(epoll_fd,EPOLL_CTL_ADD,0,&event);
    if (successful_add == -1) {
        printf("Error has occured when adding event to epoll %s",stderr);
        return 1;
    }

    // Listen for events
    int is_running = 1;
    while (is_running) {
        printf("Waiting for input...\n");
        int number_of_events_to_process = epoll_wait(epoll_fd,events_ready,MAX_NUMBER_OF_EVENTS_TO_PROCESS,-1); // blocked
        printf("Some %d events are ready\n",number_of_events_to_process);
        for (int i = 0 ; i <number_of_events_to_process; i++) {
            int event_ready_fd = events_ready[i].data.fd;
            int bytes_read = read(event_ready_fd,buffer,MAX_NUMBER_OF_BYTES);
            printf("Byte read = %d -- data = %s\n",bytes_read,buffer);
        }
    }

    if (close(epoll_fd)) {
        printf("Error has occured when closing epoll %s",stderr);
        return 1;
    }
    return 0;
}