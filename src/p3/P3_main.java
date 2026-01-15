package p3;

public class P3_main {
    public static void main(String[] args) {
        int ergebnis = 0;
        double kapital = 1004, zinsen = 0.05, jahre = 1;

        if (jahre > 0) {
            kapital = kapital + kapital * zinsen;
            kapital = Math.round(kapital);
            jahre--;
        }

        System.out.println("kapital: " + kapital);
    }
}
