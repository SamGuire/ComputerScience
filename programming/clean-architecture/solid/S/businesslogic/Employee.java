package businesslogic;

import utility.Utility;

public class Employee {

    public Employee() {
    }

    public void calculatePay(){
        System.out.println("calculatePay function called V1");
        Utility.regularHours();
    };
    public void save(){
        System.out.println("save function called V1");
    }

    public void reportHours(){
        System.out.println("reportHours called V1");
        Utility.regularHours();
    }
}
