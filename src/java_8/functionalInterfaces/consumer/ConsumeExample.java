package java_8.functionalInterfaces.consumer;

import java.util.Locale;
import java.util.function.Consumer;

public class ConsumeExample {
    public static void main(String[] args) {
        Consumer<String> c1 = (s)-> System.out.println(s.toUpperCase());
        c1.accept("this");
    }
}
