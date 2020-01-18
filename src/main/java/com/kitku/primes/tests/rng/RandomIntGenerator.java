package com.kitku.primes.tests.rng;

public interface RandomIntGenerator {
    int nextInt();

    int nextRangedClosedInt(int lower, int upper);
}


