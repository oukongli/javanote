package com.shdev.demo.algorithms;

/**
 * Created by ou_ko on 2016/10/9.
 */
public class NQueenIteration {
    private int n; //皇后个数
    private int[] x; //解
    private int sum; //可行方案

    public int nQueen(int n) {
        this.n = n;
        sum = 0;
        x = new int[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = -1;
        }
        backtrack();
        return sum;
    }

    private boolean place(int t) {
        for (int i = 0; i < t; i++) {
            if ((Math.abs(t - i) == Math.abs(x[t] - x[i])) || x[i] == x[t])
                return false;
        }
        return true;
    }

    private void backtrack() {
        x[1] = -1;
        int k = 0;
        while (k >= 0) {
            x[k] += 1;
            while (x[k] <= n - 1 && !place(k)) x[k] += 1;
            if (x[k] <= n - 1) {
                if (k >= n - 1) {
                    sum++;
                } else {
                    k++;
                    x[k] = -1;
                }
            } else {
                k--;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 4; i < 10; i++) {
            System.out.println(new NQueen().nQueen(i));
            System.out.println(new NQueenIteration().nQueen(i));
        }
    }
}
