package com.kitku.primes.tests;

import com.kitku.primes.tests.rng.DefaultRandomIntGenerator;
import com.kitku.primes.tests.rng.RandomIntGenerator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    //com.kitku.primes.tests.RealAKSTest mockTestAKS = mock(com.kitku.primes.tests.RealAKSTest.class);
    //private Calculator calc = new Calculator(mockTestAKS);
/*
    @Test
    public void shouldReturnValuesOfRomanNumbers(){
        when(mockTranslator.translate("X")).thenReturn(10);
        int result = calc.sum("X");
        assertEquals(10, result);
    }

 */
    private RandomIntGenerator intGenerator = new DefaultRandomIntGenerator();
    private FermatTest FT= new FermatTest(10, intGenerator);
    private AKSTest aks=new AKSTest();
    private MillerRabinTest mr= new MillerRabinTest(10,intGenerator);
    private SolovayStrassenTest ss = new SolovayStrassenTest(10, intGenerator);
    @Test
    public void shouldReturnPrimeForFermat(){
        assertTrue(FT.isPrime(727));
    }
    @Test
    public void shouldNOTReturnPrimeForFermat(){
        assertFalse(FT.isPrime(728));
    }
    @Test
    public void shouldReturnPrimeForAKS(){
        assertTrue(aks.isPrime(13));
    }
    @Test
    public void shouldNOTReturnPrimeForAKS(){
        assertFalse(aks.isPrime(63));
    }
    @Test
    public void shouldReturnPrimeForMR(){
        assertTrue(mr.isPrime(7));
    }
    @Test
    public void shouldNOTReturnPrimeForMR(){
        assertFalse(mr.isPrime(1441));
    }
    @Test
    public void shouldReturnPrimeForSS(){ assertTrue(ss.isPrime( 727));
    }
    @Test
    public void shouldNOTReturnPrimeForSS(){
        assertFalse(ss.isPrime( 1441));
    }
    @Test
    public void shouldReturnPrimeForFermatAndNOTForMR1case() {
        //Carmichael number
        assertTrue(FT.isPrime(561));
    }

    @Test
    public void shouldReturnPrimeForFermatAndNOTForMR2Case()
    {
        assertFalse(mr.isPrime(561));
    }
    @Test
    public void shouldReturnTrueForFermatPseudoprimesTest() { assertTrue(FermatPseudoPrimeTest.isPseudoPrime(561, 2)); }
    @Test
    public void shouldReturnFalseForFermatPseudoprimesTest() { assertFalse( FermatPseudoPrimeTest.isPseudoPrime(13, 2)); }
}
