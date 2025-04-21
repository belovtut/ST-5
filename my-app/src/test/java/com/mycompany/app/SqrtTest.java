package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    private static final double DELTA = 0.00000001;
    private Sqrt sqrt;

    @BeforeEach
    public void setUp() {
        sqrt = new Sqrt(2.0);
    }

    @Test
    public void testConstructorPositive() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(4.0, sqrt.arg, DELTA);
    }

    @Test
    public void testConstructorZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.arg, DELTA);
    }

    @Test
    public void testAveragePositive() {
        assertEquals(3.0, sqrt.average(2.0, 4.0), DELTA);
    }

    @Test
    public void testAverageZero() {
        assertEquals(1.0, sqrt.average(0.0, 2.0), DELTA);
    }

    @Test
    public void testGoodExact() {
        assertTrue(sqrt.good(Math.sqrt(2.0), 2.0));
    }

    @Test
    public void testGoodInaccurate() {
        assertFalse(sqrt.good(1.0, 2.0));
    }

    @Test
    public void testImprove() {
        assertEquals(1.5, sqrt.improve(1.0, 2.0), DELTA);
    }

    @Test
    public void testIterExact() {
        double result = sqrt.iter(Math.sqrt(2.0), 2.0);
        assertEquals(Math.sqrt(2.0), result, DELTA);
    }

    @Test
    public void testCalcSqrt2() {
        sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcLargeNumber() {
        sqrt = new Sqrt(1e10);
        assertEquals(Math.sqrt(1e10), sqrt.calc(), DELTA * 1e5);
    }


    @Test
    public void testImproveLargeX() {
        assertEquals(500000.5, sqrt.improve(1.0, 1e6), DELTA * 1e5);
    }

    @Test
    public void testIterInaccurateGuess() {
        double result = sqrt.iter(100.0, 2.0);
        assertEquals(Math.sqrt(2.0), result, DELTA);
    }
}