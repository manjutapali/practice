import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

class ParallelStream {

    public static void main(String args[]) {
        List<Pair> pairs = Stream.generate(() -> new Pair(new Random().nextInt(1000), new Random().nextInt(500)))
                .limit(1000).collect(Collectors.toList());

        long t1, t2, count;
        t1 = System.currentTimeMillis();
        count = pairs.stream().filter((p) -> p.getSum() > p.x).count();
        System.out.println("Count = " + count);
        t2 = System.currentTimeMillis();
        System.out.println("Time taken = " + (t2 - t1));

        t1 = System.currentTimeMillis();
        count = pairs.parallelStream().filter((p) -> p.getSum() > p.x).count();
        System.out.println("Count = " + count);
        t2 = System.currentTimeMillis();
        System.out.println("Time taken = " + (t2 - t1));

    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getSum() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x + y;
    }
}