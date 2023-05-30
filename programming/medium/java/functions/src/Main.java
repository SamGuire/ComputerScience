public class Main {

    public static void main(String[] args) {
        Functions.StaticInnerClass g = new Functions.StaticInnerClass();
        Functions f = new Functions();
        Functions.InnerClass h = f.new InnerClass();
        g.run();
        h.run();
    }
}
