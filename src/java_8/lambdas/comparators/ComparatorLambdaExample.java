package java_8.lambdas.comparators;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {

        /***
         * prior to java - 8
         */

        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of the comparator : "+ comparator1.compare(0,2));

        Comparator<Integer> comparator2 = (a,b) -> a.compareTo(b);
        System.out.println("Result of the comparator : "+ comparator2.compare(0,2));
    }
}
