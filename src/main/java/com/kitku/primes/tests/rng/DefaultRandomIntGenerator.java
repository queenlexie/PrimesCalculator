package com.kitku.primes.tests.rng;

import java.util.Random;

public class DefaultRandomIntGenerator implements RandomIntGenerator {

    private Random random;

    public DefaultRandomIntGenerator(){
        this.random = new Random();
    }

    @Override
    public int nextInt() {
        return random.nextInt();
    }
}
