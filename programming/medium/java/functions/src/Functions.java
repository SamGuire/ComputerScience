public class Functions {

    static class StaticInnerClass {
        void run() {
            System.out.println("Run in StaticInnerClass");
        }
    }

    class InnerClass {
        void run() {
            System.out.println("Run in InnerClass");
        }
    }

    static void f(int a) {
        System.out.printf("In function f int with param %d\n",a);
    }
    static void f(byte a) {
        System.out.printf("In function f byte with param %d\n",a);
    }
    static void f(short a) {
        System.out.printf("In function f short with param %d\n",a);
    }
    static void f(long a) {
        System.out.printf("In function f long with param %d\n",a);
    }


}