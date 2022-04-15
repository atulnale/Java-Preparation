package executor.callable;

import java.util.concurrent.*;

class MyPrinter{
    public static int printToConsole(String str){
        for(int i = 0; i< 2009; i++) {
            System.out.print(str);
        }
        return 0;
    }
}

/***
 * callable is used to get output.
 * since runnable has run  method which is void
 */
class MyPrinterTask implements Callable<Integer> {
    String str;
    MyPrinterTask(String str) {
        this.str = str;
    }
    @Override
    public Integer call() throws Exception {
        return MyPrinter.printToConsole(str);
    }
}
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future =  executorService.submit(new MyPrinterTask("M"));
        while(!future.isDone());
        System.out.println(future.get());


        //without creating class
       future =  executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return MyPrinter.printToConsole("T");
            }
        });
        while(!future.isDone());
        System.out.println(future.get());

    }
}
