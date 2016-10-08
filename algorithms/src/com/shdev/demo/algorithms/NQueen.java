package com.shdev.demo.algorithms;

/**
 * Created by ou_ko on 2016/10/8.
 */
public class NQueen {
    private int n; //皇后个数
    private int[] x; //解
    private int sum; //可行方案

    public int nQueen(int n) {
        this.n = n;
        sum = 0;
        x = new int[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = 0;
        }
        backtrack(0);
        return sum;
    }

    private void backtrack(int t) {
        if (t >= n) {
            sum++;
        } else {
            for (int i = 0; i < n; i++) {
                x[t] = i;
                if (place(t)) {
                    backtrack(t + 1);
                }
            }
        }
    }

    private boolean place(int t) {
        for (int i = 0; i < t; i++) {
            if ((Math.abs(t - i) == Math.abs(x[t] - x[i])) || x[i] == x[t])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().nQueen(4));
        System.out.println(new NQueen().nQueen(8));
    }
}
