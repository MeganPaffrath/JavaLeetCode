package com.meganpaffrath;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class Problem_7Test
{
    /**
     * Rigorous Test :-)
     */
    public Problem_7 problem7;
    @Before // anything here will run before tests
    public void setup() {
        problem7 = new Problem_7();

    }
    @Test
    public void val1463847412()
    {
        assertTrue( problem7.reverse(1463847412) == 2147483641);
    }
    @Test
    public void val123()
    {
        assertTrue( problem7.reverse(123) == 321);
    }
    @Test
    public void maxTest() {
        assertTrue(problem7.reverse(2147483647) == 0);
    }
    @Test
    public void aboveMax() {
        assertTrue(problem7.reverse(1463847413) == 0);
    }
    @Test
    public void belowMax() {
        assertTrue(problem7.reverse(-1463847413) == 0);
    }
}
