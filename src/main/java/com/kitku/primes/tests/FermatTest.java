package com.kitku.primes.tests;

import com.kitku.primes.tests.rng.RandomIntGenerator;

import java.util.stream.Stream;

import static com.kitku.primes.tests.Utils.powerMod;

public class FermatTest implements PrimalityTesting {

    private final int k;
    private final RandomIntGenerator rng;

    public FermatTest(int trials, RandomIntGenerator rng) {
        k = trials;
        this.rng = rng;
    }

    // If n is prime, then always returns true,  
    // If n is composite than returns false with  
    // high probability Higher value of k increases 
    //  probability of correct result.
    @Override
    public boolean isPrime(int n) {
        // Corner cases
        if (n <= 1 || n == 4)
            return false;
        else if (n <= 3)
            return true;
        else {
            return Stream.generate(()->rng.nextRangedClosedInt(2, n-2))
                    .limit(Math.min(k, n))
                    .filter(a->Utils.GCD(n,a)==1)
                    .allMatch(a -> powerMod(a, n - 1, n) == 1);



        }

    }
}