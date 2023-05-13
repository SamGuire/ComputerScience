#include <stdlib.h>
#include <stdio.h>
void reverse_str(char * s, int length) {
    char * l; 
    char * r;
    l = s;
    r = s+length-1;
    char tmp;
    while (l != r) {
        tmp = (*l);
        (*l) = (*r);
        (*r)=tmp;
        l++;r--;
    }
}
int main() {
    char * str = malloc(10*(sizeof(char)));
    printf("Enter a text: ");
    scanf("%s",str);
    int length = 0;
    char * cur = str;
    while ((*cur) != '\0') {
        length++;
        cur++;
    }
    printf("String captured: %s %d\n",str,length);
    reverse_str(str,length);
    printf("String captured: %s %d\n",str,length);
    free(str);
}