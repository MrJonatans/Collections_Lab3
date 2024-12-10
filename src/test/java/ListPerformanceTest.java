import org.collections.ListPerformance;

public class ListPerformanceTest {

    public static void main(String[] args) {
        int iterations = 1000; // Change this to test with different numbers of iterations
        String result = ListPerformance.runTests(iterations);
        System.out.println(result);
    }
}