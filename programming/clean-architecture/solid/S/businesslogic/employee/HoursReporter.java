package businesslogic.employee;

import utility.Utility;

public class HoursReporter {

    public static void reportHours(Employee employee) {
        System.out.println("reportHours called V1");
        HoursReporter.regularHours();
    }

    private static void regularHours() {
        System.out.println("Utility function regularhours called V1");
    }
}
