package pos;

import java.io.Serializable;

public class Sample implements Serializable {
    static final long serialVersionUID = 1L;
    private String name;
    private transient int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void method(Integer i){
        System.out.println("A1 int");
    }
}
