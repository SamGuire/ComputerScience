#include "employee.h"
struct Engineer {
    int salary;
    struct Employee base;
};
struct Engineer createEngineer(char * name);