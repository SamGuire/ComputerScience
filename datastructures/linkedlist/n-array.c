#include <stdio.h>
#include <stdlib.h>

void print_array(int * ptr,int size) {
    for (int i = 0 ; i < size ; i++) {
        printf("%d ", ptr[i]);
    }
    printf("\n");
}

/**
 * This is a standard n-array element to show the benefits of a Linked List datastructure.
 * Although random access is possible, removal and insertion of elements is costly. Take a look at the invalid memory read error in log.txt 
 * 
 * 
*/
int main() {
    int array_length = 10;
    int * ptr = malloc(array_length*sizeof(int));
    for (int i = 0 ; i < array_length; i++) {
        ptr[i] = i+1;
    }

    print_array(ptr,array_length);

    // Remove element at index 5;
    int removed_idx = 5;
    ptr[removed_idx] = NULL;
    for (int i = removed_idx+1;i<array_length;i++ ) ptr[i-1] = ptr[i];
    array_length--;
    ptr = realloc(ptr,array_length*(sizeof(int)));

    print_array(ptr,array_length);

    /// Insert new elements, asumming the array is full, requires copying the old into the new array (new-array-size = array-size+1), and inserting the element at the end of the new array

    int copy_length = array_length+1;
    int new_element = 100;
    int * copy_ptr = malloc(copy_length*(sizeof(int)));
    for (int i = 0 ; i < array_length; i++) {
        copy_ptr[i] = ptr[i];
    }

    copy_ptr[copy_length-1] = new_element;
    free(ptr);
    ptr = copy_ptr;
    copy_ptr = NULL;
    array_length = copy_length;

    print_array(ptr,array_length);
    free(ptr);
    

}