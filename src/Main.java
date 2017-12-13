import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bitte eine Primzahl eingeben!");
        Scanner sc = new Scanner(System.in);
        int p;
        while (true) {
            while (!sc.hasNextInt()) sc.next();
            p = sc.nextInt();
            if (isPrime(p)) {
                break;
            }
            System.out.println("Zahl ist keine Primzahl! Bitte eine Primzahl eingeben!");
        }

        int q;
        System.out.println("Bitte eine weitere Primzahl eingeben!");
        while (true) {
            while (!sc.hasNextInt()) sc.next();
            q = sc.nextInt();
            if (isPrime(q)) {
                break;
            }
            System.out.println("Zahl ist keine Primzahl! Bitte eine Primzahl eingeben!");
        }
        int n = p * q;
        int phi = (q-1)*(p-1);

        int e;
        System.out.println("Bitte eine Zahl eingeben die zwischen " + 1 + " und " + phi + " liegt und Teilfremd zu " + phi + " ist.");
        while (true) {
            while (!sc.hasNextInt()) sc.next();
            e = sc.nextInt();
            // Teilerfremd wenn ggT 1 ist
            if(ggT(phi,e) == 1){
                break;
            }
            System.out.println("Zahl ist nicht Teilerfremd!");
        }

        int[] ew = eukl(phi,e);
        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + ew[2] + ", " + n + ")");
    }

    /**
     * Check if prime number
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {

        if (n % (n / 2) == 0) {
            return false;
        }
        return true;
    }

    /**
     * Extended Euclidean algorithm
     *
     * @param phi
     * @param e
     * @return
     */
    public static int[] eukl(int phi, int e){
        if(e == 0){
            int[] ret = {phi,1,0};
            return ret;
        } else {
            int[] dst = eukl(e, phi%e);
            int newT = dst[1]-(phi/e)*dst[2];
            int[] newDst = {dst[0], dst[2], newT};

            return newDst;
        }
    }

    /**
     * ggT
     *
     * @param a
     * @param b
     * @return
     */
    public static int ggT(int a, int b){
        if(b == 0){
            return a;
        } else {
            return ggT(b, a % b);
        }
    }
}