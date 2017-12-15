/*
Initial Release
 */

import java.util.Scanner;

public class Main {
    static Integer phi;
    static Integer p;
    static Integer q;
    static Integer e;
    static Integer n;
    static Integer rest;
    static boolean isPrime;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Wählen sie zwei Primzahlen");

        /*
        Starte den Input reader, um die Zahlen zu erfassen
         */
        p = reader.nextInt();
        q = reader.nextInt();

        /*
        Prüfe, ob die Eingaben Primzahlen sind
         */
        isPimaryNumber(p);
        isPimaryNumber(q);

        System.out.println("Ihre Primzahlen sind \np: " + p + " \nund q: " + q);

        /*
        Berechnung der Euleschen Funktion
         */
        phi = (p-1)*(q-1);
        System.out.println("Die eulesche Funktion ergibt: " + phi);
        System.out.println("Geben sie nun eine teilfremde Zahl zur euleschen Funktion ein: ");

        /*
        Erfasse eine Teilfremde Zahl
         */
        e = reader.nextInt();
        reader.close();
        System.out.println("Ihre teilfremde Zahl ist: " + e);

        /*
        Berechnung des Inversen d zu e
         */
        eukl(phi, e);



    }
    public static void isPimaryNumber(int n){
        for(int i=2;i<=n/2;i++)
        {
            n=n%i;
            if(n==0)
            {
                System.out.println("Bitte nur Primzahlen!");
                System.exit(0);
            }

        }
    }

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
}

