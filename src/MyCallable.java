import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {

    private Range range;

    public MyCallable(Range range) {
        this.range = range;
    }

    @Override
    public Long call() throws Exception {
        long sum = Summa.sumRange(range.getStart(), range.getEnd());
        System.out.println("range "+range.getStart()+":"+ range.getEnd()+" >>> "+sum);
        return sum;

    }
}