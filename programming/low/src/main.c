#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "model/employee.h"
int main(){
    struct Employee * e = createEmployee("Issam");
    e->print_name(e);
    free(e);

}