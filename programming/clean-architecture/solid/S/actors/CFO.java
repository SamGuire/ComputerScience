package actors;

import businesslogic.employee.Employee;

public class CFO {
    public void run(){
        System.out.println("##################################### Running CFO actor process...#####################################");
        Employee e = new Employee();
        e.calculatePay();
        System.out.println("##################################### Ending CFO actor process...#####################################\n");
    }
}
