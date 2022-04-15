class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i< 1000; i++) {
            System.out.print("C");
        }
    }
}
class MyTask implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i< 1000; i++) {
            System.out.print("R");
        }
    }
}
public class SimpleThreadDemo {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        Thread task = new Thread(new MyTask());
        thread.start();
        task.start();
        for(int i = 0; i< 1500; i++) {
            System.out.print("M");
        }
    }
}
