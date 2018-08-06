package com.company;

/**
 * Partitions the array of specified as the command-line.
 * Assumes there are at most 2 distinct elements.
 */

public class Sort2distinct {

    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


}
