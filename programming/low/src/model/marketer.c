#include "employee.h"

int DEFAULT_SALARY = 60000;
void print_marketer(struct Marketer * this) {
    printf("Marketer = %s\n",(*this).base.name);

}
struct Marketer {
    int salary;
    struct Employee base;
};


struct Marketer * createMarketer(char * name) {
    struct Marketer * this = malloc(sizeof(struct Marketer));
    (*this).salary = DEFAULT_SALARY;
    (*this).base.name = name;
    (*this).base.print_name = print_marketer;
    return this;
}