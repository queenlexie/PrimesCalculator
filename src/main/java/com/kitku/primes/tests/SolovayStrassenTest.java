package com.kitku.primes.tests;

import com.kitku.primes.tests.rng.RandomIntGenerator;

import java.util.stream.Stream;

import static com.kitku.primes.tests.Utils.computeJacobiSymbol;
import static com.kitku.primes.tests.Utils.powerMod;

public class SolovayStrassenTest implements PrimalityTesting {

    private final RandomIntGenerator rng;
    private final int iterations;

    public SolovayStrassenTest(int iterations, RandomIntGenerator rng) {
        this.iterations = iterations;
        this.rng = rng;
    }

    @Override
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        else
            return generateNonNegativeDistinctInts().allMatch(r -> isJacobianConditionSatisfied(n, r));
    }

    private Stream<Integer> generateNonNegativeDistinctInts(){
        return Stream.generate(() -> Math.abs(rng.nextInt()))
                .distinct()
                .limit(iterations);
    }

    private boolean isJacobianConditionSatisfied(int n, int r) {
        int a = r % (n - 1) + 1;
        int jacobian = (n + computeJacobiSymbol(a, n)) % n;
        int mod = powerMod(a, (n - 1) / 2, n);
        return !(jacobian == 0 || mod != jacobian);
    }
}
