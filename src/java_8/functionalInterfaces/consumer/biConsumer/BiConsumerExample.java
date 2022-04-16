package java_8.functionalInterfaces.consumer.biConsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer = (a,b) -> {
            System.out.println("a:" + a+ ", b:"+b);
        };
        biConsumer.accept("Hello", "World");

    }
}
