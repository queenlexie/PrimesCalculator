package com.kitku.primes.tests;

import static com.kitku.primes.tests.Utils.*;

public class FermatPseudoPrimeTest {

    // Function to check for Fermat Pseudoprime
    // If it is composite and
    // satisfy Fermat criterion
    //mean it is pseudoprime
    public static boolean isPseudoPrime(int n, int a) {
        return a > 1 && isComposite(n) && powerMod(a, n - 1, n) == 1;
    }
}

