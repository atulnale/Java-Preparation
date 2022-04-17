package java_8.functionalInterfaces.Function;

import java.util.Locale;
import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> function = (s) -> s.toUpperCase();
    static Function<String, String> addSomeString = (s) -> s.concat(" default");

    public static void main(String[] args) {
        System.out.println("Result is : " + function.apply("java8"));
        System.out.println("Result of andThen is : " + function.andThen(addSomeString).apply("java8"));
        System.out.println("Result of compose is : " + function.compose(addSomeString).apply("java8"));  //// this will first evaluate addSomeString and then function
    }
}
