package com.kitku.primes.tests;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerModTest {

    @Test
    public void powerModShouldReturn1WhenExponentIsEqualToOne(){
        int actualResult = Utils.powerMod(13, 0, 12);
        assertEquals(1, actualResult);
    }

    @Test
    public void powerModShouldReturnBaseWhenExponent1Passed(){
        int actualResult = Utils.powerMod(13, 1, 14);
        assertEquals(13, actualResult);
    }

    @Test
    public void powerModShouldReturn2WhenExponent1Passed(){
        int actualResult = Utils.powerMod(13, 1, 11);
        assertEquals(2, actualResult);
    }

    @Test
    public void powerModShouldReturnDupa1(){
        int actualResult = Utils.powerMod(10, 560, 561);
        assertEquals(1, actualResult);
    }
}
