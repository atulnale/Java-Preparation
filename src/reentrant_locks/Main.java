package reentrant_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample {
    int i;
    ReadWriteLock rw_lock = new ReentrantReadWriteLock();
    Lock lock = rw_lock.writeLock();
    Sample(int i ){
        this.i = i;
    }
    int get(){
        return i;
    }
    void set(int i){
        this.i = i;
    }
    void incr()  {
        lock.lock();
        try {
            int x = get();

            x++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            set(x);
        } finally {
            lock.unlock();
        }
    }
}
class MyTask implements Runnable {
    Sample obj;
    MyTask(Sample obj) {
        this.obj = obj;
    }
    @Override
    public void run() {
        obj.incr();
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sample obj = new Sample(10);
        Thread th1 = new Thread(new MyTask(obj));
        Thread th2 = new Thread(new MyTask(obj));
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(obj.get());
    }
}
