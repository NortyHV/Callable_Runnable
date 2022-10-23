import java.util.ArrayList;
import java.util.List;

public class Range {
        long start;
        long end;

        public Range(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

    public static List<Range> ranges (long n, long k){
        List<Range> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            list.add(new Range(n/k * i+1, n/k * (i+1)));

        }
        return list;

    }
    }

