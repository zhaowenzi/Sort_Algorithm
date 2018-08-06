package com.company;

import edu.princeton.cs.algs4.StdRandom;

import java.util.LinkedList;
import java.util.Random;

public class QuickNoRec {

    private static Random random = new Random();

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        //need to assure that a is not null
        //the target is to shuffle the array
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n-i);     // between i and n-1
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        if (lo < hi) {
            stack.push(hi);
            stack.push(lo);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if(j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
