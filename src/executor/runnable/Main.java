package executor.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrinterTask implements Runnable {
    String symbol;
    PrinterTask(String symbol){
        this.symbol = symbol;
    }
    @Override
    public void run() {
        Printer.printToConsole(symbol);
    }
}
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new PrinterTask("M"));
        executorService.execute(new PrinterTask("T"));
        executorService.execute(new PrinterTask("P"));
    }
}
