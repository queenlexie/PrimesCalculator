package com.kitku.primes.tests;

import com.kitku.primes.tests.rng.RandomIntGenerator;

import java.util.stream.Stream;

import static com.kitku.primes.tests.Utils.*;

public class MillerRabinTest implements PrimalityTesting {
    // This function is called for all k trials.
    // It returns false if n is composite and
    // returns false if n is probably prime.
    // d is an odd number such that d*2<sup>r</sup>
    // = n-1 for some r >= 1

    private final int k;
    private final RandomIntGenerator rng;

    public MillerRabinTest(int trials, RandomIntGenerator rng){
        this.k = trials;
        this.rng = rng;
    }

    @Override
    public boolean isPrime(int n) {
        if (n <= 1 || n == 4)
            return false;
        else if (n <= 3)
            return true;
        else {
            int d = findDFor(n);
            return Stream.generate(()->rng.nextRangedClosedInt(2, n-2) % (n-4))
                    .distinct()
                    .limit(k)
                    .allMatch(a -> isTestSatisfied(a, d, n));
        }
    }

    //TODO: Name it better
    private int findDFor(int n){
        int d = n - 1;
        while (d % 2 == 0)
            d /= 2;
        return d;
    }

    private boolean isTestSatisfied(int a, int d, int n) {
        // Compute a^d % n
        int x = powerMod(a, d, n);

        if (x == 1 || x == n - 1)
            return true;

        // Keep squaring x while one of the
        // following doesn't happen
        // (i) d does not reach n-1
        // (ii) (x^2) % n is not 1
        // (iii) (x^2) % n is not n-1
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }

        // Return composite
        return false;
    }
}
