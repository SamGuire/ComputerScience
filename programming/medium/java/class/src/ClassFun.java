public class ClassFun {

    private String hidden = "HIDDEN";
    protected String myChildrenPackageOnly = "PROTECTED";

    public String everyone = "PUBLIC";

    public ClassFun(){}

    public void accessHidden(ClassFun other) {
        System.out.printf("%s\n",other.hidden);
    }
}
