package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

class ProducerThread extends Thread {
    MessageQueue obj;
    ProducerThread(MessageQueue obj ) {
        this.obj = obj;
    }
    @Override
    public void run() {
        for(int i = 0; i<15; i++) {
            System.out.println("Produced Message: "+ String.valueOf(i));
            obj.enque(String.valueOf(i));
        }
    }
}
class ConsumerThread extends Thread {
    MessageQueue obj;
    ConsumerThread(MessageQueue obj ) {
        this.obj = obj;
    }
    @Override
    public void run() {
        for(int i = 0; i<15; i++) {
            System.out.println("Consumed Message: "+ obj.deque());
        }
    }
}
class MessageQueue {
    Queue<String> q;
    int size;
    MessageQueue(int size) {
        this.size = size;
        q = new LinkedList<>();
    }

    boolean isFull() {
        return q.size() == this.size;
    }
    boolean isEmpty(){
        return q.size() == 0;
    }
    synchronized void enque(String message) {
        while(isFull()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        q.add(message);
        this.notify();
    }

    synchronized String deque() {
        while(isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String message = q.poll();
        this.notify();
        return message;
    }
}
public class Main {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(3);
        Thread producer = new ProducerThread(queue);
        Thread consumer = new ConsumerThread(queue);
        producer.start();
        consumer.start();

    }
}
