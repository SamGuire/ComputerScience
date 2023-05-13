struct Employee {
    char * name;
    void (*print_name)(struct Employee * this);
};
struct Employee * createEmployee(char * name) ;
