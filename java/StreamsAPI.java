import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class StreamsAPI {

    public static void main(String args[]) {
        Stream<Integer> randomNums = Stream.generate(() -> new Random().nextInt(100)).limit(1000);

        Stream<Integer> numDevisibleBy3 = randomNums.filter(num -> (num % 3 == 0));

        Stream<Integer> actualNumbers = numDevisibleBy3.map(num -> num * 3);

        Stream<Integer> sortedNums = actualNumbers.sorted(Comparator.reverseOrder());

        sortedNums.forEach((num) -> {
            System.out.print(num + ",");
        });

        System.out.println();
    }
}