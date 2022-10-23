
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class Logical {

    private long sum;

    public Logical() {
    }

    void summaRunn(int n, int k) {

        Summa summa = new Summa();
        ExecutorService pool = Executors.newFixedThreadPool(k);
        List<Range> ranges = Range.ranges(n, k);
        for (int i=0; i<k; i++) {
            pool.submit(new MyRunnable(summa, ranges.get(i)));
        }

        pool.shutdown();

        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        summa.print();

    }

    void summaCall(int n, int k) {

        List<Future<Long>>  futures = new ArrayList<>();


        ExecutorService pool = Executors.newFixedThreadPool(k);
        List<Range> ranges = Range.ranges(n, k);
        for (int i=0; i<k; i++) {
            futures.add(pool.submit(new MyCallable(ranges.get(i))));
        }

        pool.shutdown();

        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long total = 0;
        for (Future<Long> future: futures) {
            try {
                total += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total="+total);

    }



}