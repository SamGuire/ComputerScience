#include <stdlib.h>
#include <stdio.h>

/**
 * Linked Lists sacrifies random access and memory for easier and faster removal and insertion of elements. Asumming you need a LIFO or FIFO data structure,
 * Linked Lists is a good candidate for the task. Take notice that memory management is more difficult than standard arrays, this complexity can add up
 * alot if the data you are working with is not primative (i.e objects). Reallocation in the advant of insertion or removal is also not needed for linkedlist due to the 
 * size being dynamic by nature.
 * 
 * */
typedef struct Node {
    int v;
    struct Node * next;
} ListNode;

void insert_in_ll(ListNode * dummy_head,int v ) {
    ListNode * cur = dummy_head;
    while ((*cur).next != NULL) {
        cur = (*cur).next;
    }
    ListNode * new_node = malloc(sizeof(ListNode));
    (*new_node).next = NULL;
    (*new_node).v = v;
    (*cur).next = new_node;
}

void remove_from_ll(ListNode * dummy_head, int target_idx) {
    ListNode * cur = dummy_head;
    int idx = 0;
    while ((*cur).next != NULL && idx != target_idx ) {
        cur = (*cur).next;
        idx+=1;
    }
    if ((*cur).next != NULL) {
        ListNode * to_remove = (*cur).next;
        (*cur).next = (*to_remove).next;
        free(to_remove);
    }
}

void print_ll(ListNode * dummy_head) {
    ListNode * cur = (*dummy_head).next;
    while (cur != NULL) {
        printf("%d ", (*cur).v);
        cur = (*cur).next;
    }
    printf("\n");
}

void destroy_ll(ListNode * dummy) {
    ListNode * cur = dummy;
    ListNode * next_node_to_destroy;
    while (cur != NULL) {
        next_node_to_destroy = (*cur).next;
        free(cur);
        cur = next_node_to_destroy;
    }
}

int main() {
    int array_length = 10;

    ListNode * dummy = malloc(sizeof(ListNode));
    (*dummy).next = NULL;
    (*dummy).v = -1;


    for (int i = 0 ; i < array_length; i++) {
        insert_in_ll(dummy,i+1);
    }
    print_ll(dummy);

    int remove_idx = 5;
    remove_from_ll(dummy,remove_idx);
    print_ll(dummy);

    int new_element = 100;
    insert_in_ll(dummy,new_element);
    print_ll(dummy);
    destroy_ll(dummy);

}