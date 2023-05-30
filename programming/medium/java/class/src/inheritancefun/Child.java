package inheritancefun;

public class Child extends Parent{

    private String hidden = "HIDDENCHILDFIELD";

    public void run() {
        System.out.println(this.hidden);
        System.out.println(this.childPackageOnly);
        super.run();
    }

}
