package com.kitku.primes.tests;

import java.util.stream.IntStream;

class Utils {

    private Utils(){}

    public static int computeJacobiSymbol(int a, int b){
        if (b <= 0 || b % 2 == 0)
            return 0;
        int j = 1;
        if (a < 0) {
            a = -a;
            if (b % 4 == 3)
                j = -j;
        }
        while (a != 0) {
            while (a % 2 == 0) {
                a /= 2;
                if (b % 8 == 3 || b % 8 == 5)
                    j = -j;
            }

            int temp = a;
            a = b;
            b = temp;

            if (a % 4 == 3 && b % 4 == 3)
                j = -j;
            a %= b;
        }
        if (b == 1)
            return j;
        return 0;
    }

    /** Function to calculate (a ^ b) % c **/
    public static int powerMod(int base, int exponent, int mod) {
        if(exponent == 0)
            return 1;
        else {
            int normalizedBase = base % mod;
            if (exponent == 1)
                return normalizedBase;
            else if (exponent % 2 == 1)
                return normalizedBase * powerMod(normalizedBase, exponent - 1, mod) % mod;
            else {
                int partialResult = powerMod(base, exponent / 2, mod);
                return partialResult * partialResult % mod;
            }
        }
    }

    // Function to check if
    // the given number is composite
    public static boolean isComposite(int n) {
        // Check if there is any divisor of n
        // less than sqrt(n)
        return IntStream.rangeClosed(2, ((int)Math.sqrt(n))+1).anyMatch(i -> n % i == 0);
    }

}
