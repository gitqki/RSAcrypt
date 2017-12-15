/*
Initial Release
 */

import java.util.Scanner;

public class Main {
    static Integer FN;
    static Integer p;
    static Integer q;
    static Integer e;
    static Integer n;
    static Integer rest;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Wählen sie zwei Primzahlen");

        /*
        Starte den Input reader, um die Zahlen zu erfassen
         */
        p = reader.nextInt();
        q = reader.nextInt();


        System.out.println("Ihre Primzahlen sind \np: " + p + " \nund q: " + q);

        /*
        Berechnung der Euleschen Funktion
         */
        FN = (p-1)*(q-1);
        System.out.println("Die eulesche Funktion ergibt: " + FN);
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
        eukl(FN, e);



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

