#include <stdio.h>
#include <stdlib.h>
#include "employee.h"
void print_employee(struct Employee * this) {
    printf("Employee = %s\n",(*this).name);

}

struct Employee  * createEmployee(char * name) {
    struct Employee * e = malloc(sizeof(struct Employee));
    (*e).print_name = print_employee;
    (*e).name = name;
    return e;
}
