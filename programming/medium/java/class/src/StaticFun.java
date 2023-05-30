public class StaticFun {
    public static final int i = 1;
    static {
        System.out.println("Initialized static members");
    }
    public StaticFun() {
        //StaticFun.i = 1;
    }

}
