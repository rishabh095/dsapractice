package pos;

@FunctionalInterface
public interface Second {
    void add();

    static void show() {
        System.out.println("static in first");
    }

    default void m1() {
        System.out.println("default in first");
    }
}
