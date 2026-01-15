package h2;

public class H2_main {
    private static final long[] cache = new long[1000];
    private static final boolean[] computed = new boolean[1000];

    public static void main(String[] args) {
        benchmark(50);
    }

    public static void benchmark(int n) {
        System.out.println("für n = " + n);

        long start1 = System.nanoTime();
        long result1 = fibonacci(n);
        long end1 = System.nanoTime();
        System.out.println("Elapsed nanoseconds (fibonacci): " + (end1 - start1));
        System.out.println("Result: " + result1);

        resetCache();

        long start2 = System.nanoTime();
        long result2 = fibonacciCached(n);
        long end2 = System.nanoTime();
        System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end2 - start2));
        System.out.println("Result: " + result2);

        resetCache();

        long start3 = System.nanoTime();
        long result3 = fibonacciIterative(n);
        long end3 = System.nanoTime();
        System.out.println("Elapsed nanoseconds (fibonacciIterative): " + (end3 - start3));
        System.out.println("Result: " + result3);
    }

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciCached(int n) {
        if (n <= 1) return n;
        if (computed[n]) {
            return cache[n];
        }
        long result = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        cache[n] = result;
        computed[n] = true;
        return result;
    }

    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    private static void resetCache() {
        for (int i = 0; i < computed.length; i++) {
            computed[i] = false;
        }
    }

}
