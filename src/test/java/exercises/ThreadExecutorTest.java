package exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadExecutorTest {
    
    ExecutorService executorService = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(10, true),
            new ThreadPoolExecutor.CallerRunsPolicy());
    
    @Test
    public void testThreadExecute(){
        executorService.execute(new CountUpToRunnable(5));
        executorService.execute(new CountUpToRunnable(10));        
    }
    
    @Test
    public void testThreadSubmitCallable() throws InterruptedException, ExecutionException {
        
        Set<Future<List<Integer>>> futures = new HashSet<Future<List<Integer>>>();
        
        futures.add(executorService.submit(new CountUpToCallable(5)));
        futures.add(executorService.submit(new CountUpToCallable(10)));
        
        for (Future<List<Integer>> future : futures) {
            for (int i : future.get()) {
                System.out.println(i);
            }
        }
    }

}

class CountUpToRunnable implements Runnable {

    private int max;
    public CountUpToRunnable(int i) {
        this.max = i;
    }
    
    @Override
    public void run() {
        for (int i=0; i<max; i++) {
            System.out.println(i);
        }
    }
}

class CountUpToCallable implements Callable<List<Integer>> {

    private int max;
    public CountUpToCallable(int i) {
        this.max = i;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();

        for (int i=0; i<max; i++) {
            integers.add(i);
        }
        return integers;
    }
}
    