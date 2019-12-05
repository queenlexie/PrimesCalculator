
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    //RealAKSTest mockTestAKS = mock(RealAKSTest.class);
    //private Calculator calc = new Calculator(mockTestAKS);
/*
    @Test
    public void shouldReturnValuesOfRomanNumbers(){
        when(mockTranslator.translate("X")).thenReturn(10);
        int result = calc.sum("X");
        assertEquals(10, result);
    }

 */
    @Test
    public void shouldReturnPrimeForFermat(){
        assertTrue(FermatTest.isPrime(727, 10));
    }
    @Test
    public void shouldNOTReturnPrimeForFermat(){
        assertFalse(FermatTest.isPrime(728, 3));
    }
    @Test
    public void shouldReturnPrimeForAKS(){
        assertTrue(AKSTest.isPrime(13));
    }
    @Test
    public void shouldNOTReturnPrimeForAKS(){
        assertFalse(AKSTest.isPrime(63));
    }
    @Test
    public void shouldReturnPrimeForMR(){
        assertTrue(MillerRabinTest.isPrime(727, 10));
    }
    @Test
    public void shouldNOTReturnPrimeForMR(){
        assertFalse(MillerRabinTest.isPrime(1441, 10));
    }
    @Test
    public void shouldReturnPrimeForSS(){ assertTrue(SolovayStrassenTest.SSIsPrime( 727, 10));
    }
    @Test
    public void shouldNOTReturnPrimeForSS(){
        assertFalse(SolovayStrassenTest.SSIsPrime( 1441, 10));
    }
    @Test
    public void shouldReturnPrimeForFermatAndNOTForMR1case()
    {
        //Carmichael number
        assertTrue(FermatTest.isPrime(561, 10));
    }

    @Test
    public void shouldReturnPrimeForFermatAndNOTForMR2Case()
    {
        assertFalse(MillerRabinTest.isPrime(561, 10));
    }
    @Test
    public void shouldReturnOneForFermatPseudoprimesTest() { assertEquals(1, FermatPseudoprimeTest.Check(561, 2)); }
    @Test
    public void shouldReturnZeroForFermatPseudoprimesTest() { assertEquals(0, FermatPseudoprimeTest.Check(13, 2)); }

}
