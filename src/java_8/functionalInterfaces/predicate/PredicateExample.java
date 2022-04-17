package java_8.functionalInterfaces.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> p = (i) -> i%2==0;
    static Predicate<Integer> p1 = (i) -> i%5 == 0;
    public static void predicateAnd(){
        System.out.println("PredicateExample.predicateAnd: ");
        System.out.println(p.and(p1).test(8));
    }
    public static void predicateOr(){
        System.out.println("PredicateExample.predicateOr: ");
        System.out.println(p.or(p1).test(8));
    }
    public static void predicateNegate() {
        System.out.println("PredicateExample.predicateNegate");
        System.out.println(p.or(p1).negate().test(8));
    }
    public static void main(String[] args) {
        predicateAnd();
        predicateOr();
        predicateNegate();
    }
}
