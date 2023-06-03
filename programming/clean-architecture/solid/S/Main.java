import actors.CFO;
import actors.COO;
import actors.CTO;

public class Main {

    public static void main(String[] args) {
        runSimulation();
    }

    public static void runSimulation() {
        CTO cto = new CTO();
        CFO cfo = new CFO();
        COO coo = new COO();

        cto.run();
        cfo.run();
        coo.run();
    }

}
