package pos;

@FunctionalInterface
public interface First {
    void add();

    static void show() {
        System.out.println("static in first");
    }

    default void m1() {
        System.out.println("default in first");
    }
}
