import java.util.stream.LongStream;

public class Summa {

    private long sum = 0;

    synchronized void add(long added) {
        sum += added;
    }

    public void print() {
        System.out.println("Summa="+sum);
    }

    public static Long sumRange(long from, long to){
        return LongStream.rangeClosed(from, to).sum();
    }

}