package pos;

import java.util.HashSet;
import java.util.Set;

public class AutoBoxingOverride {
    public static void main(String[] args) {
        String s1="";
        System.out.println(s1.length());
        Set<Integer>s=new HashSet<>();
        s.add(1);
        s.add(null);

        Addable ad=(a,b)->(a+b);
        System.out.println(ad.add(10,20));
        System.out.println(s);
        Sample a=new B();
        a.method(new Integer(5));
        a.method(5);

        B b=new B();
        b.method(new Integer(6));
        b.method(4);
    }

    static int add(int a,int b){
        return a+b;
    }
}
