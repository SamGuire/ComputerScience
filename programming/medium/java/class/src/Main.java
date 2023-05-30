//import packageonlyclub.VIP;

import inheritancefun.Child;

public class Main {

    public static void main(String[] args){
        ClassFun cf = new ClassFun();
        ClassFun cf2 = new ClassFun();
        cf2.accessHidden(cf);
        System.out.println(cf.everyone);
        System.out.println(cf.myChildrenPackageOnly);
        Child child =new Child();
        child.run();
        final int i;
        i =2;
        StaticFun sf,sf2;
        sf =new StaticFun();
        sf2 = new StaticFun();
        DeckOfCards doc = new DeckOfCards();
        System.out.println(doc);
        //i  =3;
        //VIP vip = new VIP();
        //System.out.println(cf.hidden);
    }
}
