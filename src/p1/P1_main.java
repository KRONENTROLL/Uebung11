package p1;

public class P1_main {

    public static void main(String[] args) {
        double a = 2;
        int b = 3;
        System.out.println(rekursivPotenz(a, b));
        System.out.println(iterativPotenz(a, b));
    }

    public static double rekursivPotenz(double a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * rekursivPotenz(a, b - 1);
    }

    public static double iterativPotenz(double a, int b) {
        double ergebnis = 1;
        for (int i = 0; i < b; i++) {
            ergebnis *= a;
        }
        return ergebnis;
    }
}
