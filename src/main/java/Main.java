/**
 * Calculate RSA Key with random p and q
 */
public class Main {
    // maximum number for p and q
    private static int max = 10000;

    public static void main(String[] args) {

        long p = getRandomPrime(max);
        long q = getRandomPrime(max);
        System.out.println("p = " + p + "\nq = " + q);
        long n = p * q;
        long phi = (q - 1) * (p - 1);

        System.out.println("n = " + n + "\nphi = " + phi);

        long e = getRandomPrime(phi);
        System.out.println("e = " + e);

        long[] ew = eukl(phi, e);

        while (ew[2] < 0) {
            ew[2] += phi;
        }

        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + ew[2] + ", " + n + ")");
    }

    /**
     * Check if prime number
     *
     * @param num to checking prime number
     * @return boolean
     */
    public static boolean isPrime(long num) {
        if (num == 2) {
            return (true);
        }
        for (long i = 2; i <= (long) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return (false);
            }
        }
        return (true);
    }

    /**
     * Extended Euclidean algorithm
     *
     * @param phi phi
     * @param e   e
     * @return long[]
     */
    public static long[] eukl(long phi, long e) {
        if (e == 0) {
            long[] ret = {phi, 1, 0};
            return ret;
        } else {
            long[] dst = eukl(e, phi % e);
            long newT = dst[1] - (phi / e) * dst[2];
            long[] newDst = {dst[0], dst[2], newT};

            return newDst;
        }
    }

    /**
     * ggT
     *
     * @param a first number
     * @param b second number
     * @return long
     */
    public static long ggT(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return ggT(b, a % b);
        }
    }


    /**
     * Get random prime number in range of 1 and max
     *
     * @param max       max
     * @return rnd      random number between 1 and max
     */
    private static long getRandomPrime(long max) {
        boolean prime = false;

        long rnd = 0;
        while (!prime) {
            rnd = 1 + (long) (Math.random() * (max - 1));
            prime = isPrime(rnd);
            if (ggT(max, rnd) != 1) {
                prime = false;
            }
        }
        return rnd;
    }
}