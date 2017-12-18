/*
Initial Release
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static long rand;
    static long phi;
    static long p;
    static long q;
    static long e;
    static long[] d;
    static boolean isPrime = false;

    public static void main(String[] args) {
        //Scanner reader = new Scanner(System.in);
        System.out.println("Wählen sie zwei Primzahlen");

        /*
        Starte den Input reader, um die Zahlen zu erfassen
         */
        p = randPrime(100000,200000);
        //p = reader.nextInt();

        /*
        Prüfe, ob die Eingaben Primzahlen sind
         */
        //isPimaryNumber(p);
        //System.out.println("Ihre erste Primzahl ist: "  + p + "\ngeben sie die nächste Primzahl ein.");
        q = randPrime(1,100000);
        //q = reader.nextInt();
        //isPimaryNumber(q);

        //System.out.println("Ihre zweite Primzahl ist: " + q);

        /*
        Berechnung der Euleschen Funktion
         */
        System.out.println("\np: " + p + "\nq: " + q + "\nPhi: " + (p-1)*(q-1));
        phi = (p - 1) * (q - 1);
        //System.out.println("Die eulesche Funktion ergibt: " + phi);
        //System.out.println("Geben sie nun eine teilfremde Zahl zur euleschen Funktion ein: ");

        /*
        Erfasse eine Teilfremde Zahl
         */
        e = randPrime(q,p);
        //e = reader.nextInt();
        //isPimaryNumber(e);
        //reader.close();
        System.out.println("Teilfremde Zahl: " + e);

        /*
        Berechnung des Inversen d zu e
         */
        if (!isPrime) {System.exit(1);}
        else {
            d = eukl(phi, e);
            System.out.println("Öffentlicher Schlüssel: " + e + " " + phi);
            while (d[2] < 0) {
                d[2] = d[2] + phi;
            }
            System.out.println("Privater Schlüssel: " + d[2] + " " + phi);
        }

    }
    public static void isPimaryNumber(long n){
        for (long p = 2; p < n; p++) {
            if (n % p == 0 || n <= 0) {
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }
    }

    public static long[] eukl(long phi, long e){
        if(e == 0){
            long[] ret = {phi,1,0};
            return ret;
        } else {
            long[] dst = eukl(e, phi%e);
            long newT = dst[1]-(phi/e)*dst[2];
            long[] newDst = {dst[0], dst[2], newT};
            return newDst;
        }
    }
    public static long randPrime(long min, long max) {
        isPrime = false;
        Random rn = new Random();
        long range = max - min + 1;
        long randomNum = 0;
        while (!isPrime) {
            randomNum = (rn.nextLong() % (max - min)) + min;
            isPimaryNumber(randomNum);
        }
        return randomNum;
    }
}

