package deadlock;

class Writer1 extends Thread {
    Object book;
    Object pen;
    Writer1(Object book, Object pen ) {
        this.book = book;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (book) {
            Thread.yield();
            synchronized (pen) {
                System.out.println("Writer1 is writing");
            }
        }
    }
}

class Writer2 extends Thread {
    Object book;
    Object pen;
    Writer2(Object book, Object pen ) {
        this.book = book;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (pen) {
            synchronized (book) {
                System.out.println("Writer2 is writing");
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Object book = new Object();
        Object pen = new Object();

        new Writer1(book,pen).start();
        new Writer2(book,pen).start();

        System.out.println("Main is done");
    }
}
