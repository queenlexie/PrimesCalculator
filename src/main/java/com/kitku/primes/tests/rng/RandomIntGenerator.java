package com.kitku.primes.tests.rng;

public interface RandomIntGenerator {
    int nextInt();

    default int nextRangedClosedInt(int lower, int upper){
        return lower + nextInt()*(upper - lower);
    }
}


