#include "employee.h"
struct Marketer {
    int salary;
    struct Employee base;
};
struct Marketer * createMarketer(char * name);