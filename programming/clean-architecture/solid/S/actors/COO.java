package actors;

import businesslogic.employee.Employee;

public class COO {
    public void run(){
        System.out.println("##################################### Running COO actor process...#####################################");
        Employee e = new Employee();
        e.reportHours();
        System.out.println("##################################### Ending COO actor process...#####################################\n");
    }
}
