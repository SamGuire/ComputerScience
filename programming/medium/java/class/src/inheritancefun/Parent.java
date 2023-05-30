package inheritancefun;

public class Parent {
    protected String childPackageOnly = "PROTECTEDPARENTFIELD";

    private String hidden = "HIDDEN";

    public void run() {
        System.out.println(hidden);
    }
}
