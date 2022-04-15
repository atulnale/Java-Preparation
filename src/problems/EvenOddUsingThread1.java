package problems;

class Test {
    static volatile int num = 0;
}

public class EvenOddUsingThread1 {
    public static void main(String[] args) {
        int num = 0;
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    while(Test.num %2 != 0){
                        ;
                    }
                    System.out.println("Thread1 "+ Test.num);
                    Test.num++;
                }
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    while(Test.num %2 == 0){
                        ;
                    }
                    System.out.println("Thread2 "+ Test.num);
                    Test.num++;
                }
            }
        });
        th2.start();
        th1.start();
    }
}
