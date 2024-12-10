package org.collections;

public class Main {

    public static void main(String[] args) {
        int iterations = 100000; // Def
        if (args.length > 0) {
            try {
                iterations = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default iterations: 1000");
            }
        }

        System.out.println("Running performance tests...");
        String result = ListPerformance.runTests(iterations);
        System.out.println(result);
    }
}
