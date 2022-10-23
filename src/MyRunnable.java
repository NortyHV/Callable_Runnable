public class MyRunnable implements Runnable{

    private Range range;
    private Summa summa;

    public MyRunnable(Summa summa, Range range) {
        this.summa = summa;
        this.range = range;
    }

    @Override
    public void run() {
        long sum = Summa.sumRange(range.getStart(), range.getEnd());
        System.out.println("range "+range.getStart()+":"+ range.getEnd()+" >>> "+sum);
        summa.add(sum);
    }
}