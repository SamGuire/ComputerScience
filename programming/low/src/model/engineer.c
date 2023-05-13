#include "employee.h"

int DEFAULT_SALARY = 100000;

struct Engineer {
    int salary;
    struct Employee base;
};

void print_engineer(struct Employee * this) {
    printf("Engineer = %s\n",(*this).name);

}

struct Engineer createEngineer(char * name) {
    struct Engineer eng = {DEFAULT_SALARY,{name,print_engineer}};
    return eng;
}
