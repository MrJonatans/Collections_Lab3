package org.collections;
import java.util.*;

/**
 * Utility class to compare the performance of ArrayList and LinkedList
 * for basic operations such as add, delete, and get.
 */
public class ListPerformance {

    /**
     * Measures the execution time of a given operation on a list.
     *
     * @param list The list to perform operations on.
     * @param operation The operation to perform.
     * @param iterations Number of iterations for the operation.
     * @return Time taken to complete the operation in milliseconds.
     */
    public static long measurePerformance(List<Integer> list, Runnable operation, int iterations) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            operation.run();
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    /**
     * Runs tests for add, delete, and get methods on both ArrayList and LinkedList.
     *
     * @param iterations Number of iterations for each operation.
     * @return A formatted result table as a string.
     */
    public static String runTests(int iterations) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        StringBuilder result = new StringBuilder();
        result.append("Method\tList Type\tIterations\tTime (ms)\n");

        // Test add operation
        result.append(formatResult("add", "ArrayList", iterations, measurePerformance(arrayList,
                () -> arrayList.add(0), iterations)));

        result.append(formatResult("add", "LinkedList", iterations, measurePerformance(linkedList,
                () -> linkedList.add(0), iterations)));

        // Test get operation
        // Prepopulate lists
        populateList(arrayList, iterations);
        populateList(linkedList, iterations);

        result.append(formatResult("get", "ArrayList", iterations, measurePerformance(arrayList,
                () -> arrayList.get(arrayList.size() / 2), iterations)));

        result.append(formatResult("get", "LinkedList", iterations, measurePerformance(linkedList,
                () -> linkedList.get(linkedList.size() / 2), iterations)));

        // Test delete operation
        result.append(formatResult("delete", "ArrayList", iterations, measurePerformance(arrayList,
                () -> arrayList.remove(arrayList.size() - 1), iterations)));

        result.append(formatResult("delete", "LinkedList", iterations, measurePerformance(linkedList,
                () -> linkedList.remove(linkedList.size() - 1), iterations)));

        return result.toString();
    }

    /**
     * Helper method to format a result line.
     *
     * @param method Method name.
     * @param listType List type (ArrayList or LinkedList).
     * @param iterations Number of iterations.
     * @param time Time taken for the operation in milliseconds.
     * @return Formatted result line.
     */
    private static String formatResult(String method, String listType, int iterations, long time) {
        return String.format("%s\t%s\t%d\t%d\n", method, listType, iterations, time);
    }

    /**
     * Populates a list with integers from 0 to n-1.
     *
     * @param list List to populate.
     * @param n Number of elements to add.
     */
    private static void populateList(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }
}
