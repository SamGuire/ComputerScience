package actors;

import businesslogic.employee.Employee;

public class CTO {
    public void run(){
        System.out.println("##################################### Running CTO actor process...#####################################");
        Employee e = new Employee();
        e.save();
        System.out.println("##################################### Ending CTO actor process...#####################################\n");
    }
}
