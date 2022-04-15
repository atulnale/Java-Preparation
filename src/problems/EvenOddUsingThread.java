package problems;

class Printer {
    int i = 0;
    void print(){
        System.out.println(i);
    }
    void incr(){
        ++i;
    }
}
class EvenPrinter implements Runnable {
    Printer printer;
    EvenPrinter(Printer printer){
        this.printer = printer;
    }
    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            while(printer.i %2 != 0){
                ;
            }
            System.out.println("Thread1");
            printer.print();
            printer.incr();
        }
    }
}
class OddPrinter implements Runnable {
    Printer printer;
    OddPrinter(Printer printer){
        this.printer = printer;
    }
    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            while(printer.i %2 == 0){
                ;
            }
            System.out.println("Thread2");
            printer.print();
            printer.incr();
        }
    }
}
public class EvenOddUsingThread {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread th1 = new Thread(new EvenPrinter(printer));
        Thread th2 = new Thread(new OddPrinter(printer));
        th2.start();
        th1.start();
    }
}
