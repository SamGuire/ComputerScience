package businesslogic.employee;

import utility.Utility;

public class Employee {
    public Employee() {
    }

    public void calculatePay(){
        System.out.println("calculatePay function called V1");
        this.regularHours();
    };
    public void save(){
        EmployeeSaver.save(this);
    }

    public void reportHours(){
        HoursReporter.reportHours(this);
    }
    private void regularHours() {
        System.out.println("Utility function regularhours called V2 (change for CFO)");
    }
}
