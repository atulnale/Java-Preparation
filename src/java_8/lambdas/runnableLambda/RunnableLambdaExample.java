package java_8.lambdas.runnableLambda;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        /***
         * prior to java 8
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };
        new Thread(runnable).start();

        /***
         * Java 8 lambda
         */
        Runnable runnableLambda  = () -> {
            System.out.println("Inside Lambda 1");
        };
        new Thread(runnableLambda).start();

        Runnable runnableLambda2  = () -> System.out.println("Inside Lambda 2");

        new Thread(runnableLambda2).start();

        /***
         * More optimise
         */
        new Thread(()-> System.out.println("More optimise lambda")).start();
    }
}
