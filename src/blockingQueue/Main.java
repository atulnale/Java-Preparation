package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Consumer extends Thread {
    BlockingQueue<Integer> queue ;
    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++) {
            try {
                System.out.println("Consumed message: "+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread {
    BlockingQueue<Integer> queue;
    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i< 10; i++) {
            try {
                System.out.println("Producing message: "+i);
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {
        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}
