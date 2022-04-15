package ThreadGroup;
class PrintTask implements Runnable {
    String str;
    PrintTask(String str) {
        this.str = str;
    }
    @Override
    public void run() {
        Printer.printToConsole(str);
    }
}
public class Main {
    public static void main(String[] args) {
        ThreadGroup grp1 = new ThreadGroup("grp1");
        Thread th1 = new Thread(grp1,new PrintTask("A"));
        grp1.setMaxPriority(3);
    }


}
