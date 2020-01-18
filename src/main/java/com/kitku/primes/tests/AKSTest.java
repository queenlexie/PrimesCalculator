package com.kitku.primes.tests;

import java.util.Arrays;

public class AKSTest implements PrimalityTesting {

    @Override
    public boolean isPrime(int n) {
        // Return true if all coefficients are
        // divisible by n.
        return Arrays.stream(coeffs(n)).allMatch(l -> l % n == 0);
    }

    // function to calculate the coefficients
    // of (x - 1)^n - (x^n - 1) with the help
    // of Pascal's triangle .
    private static long[] coeffs(int n) {
        long[] coeffs = new long[n+1];
        coeffs[0] = 1;
        for (int i = 0; i < n; coeffs[0] = -coeffs[0], i++) {
            coeffs[1 + i] = 1;
            for (int j = i; j > 0; j--)
                coeffs[j] = coeffs[j - 1] - coeffs[j];
        }
        // subtracting c[n] and adding c[0] by 1
        // as ( x - 1 )^n - ( x^n - 1), here we
        // are subtracting c[n] by 1 and adding
        // 1 in expression.
        coeffs[0]++;
        coeffs[n]--;
        return coeffs;
    }
}
