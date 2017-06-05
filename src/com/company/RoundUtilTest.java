package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pernilla on 2017-05-27.
 */
public class RoundUtilTest {
    private RoundUtil roundUtil;
    @Before
    public void setUp(){
        this.roundUtil = new RoundUtil();
    }
    @Test
    public void testRoundDownFromTopValue5To9(){
        int test = 19;
        int expected = 15;
        assertEquals("The integers after rounding down doesn't match", expected, roundUtil.roundDown(test));
        int test2 = 9;
        int expected2 = 5;
        assertEquals("The integers after rounding down doesn't match", expected2, roundUtil.roundDown(test2));
    }
    @Test
    public void testRoundDownFromMiddleValue5(){
        int test = 15;
        int expected = 15;
        assertEquals("The integers after rounding down doesn't match", expected, roundUtil.roundDown(test));
        int test2 = 5;
        int expected2 = 5;
        assertEquals("The integers after rounding down doesn't match", expected2, roundUtil.roundDown(test2));
    }
    @Test
    public void testRoundDownBottomValue0To4(){
        int test = 4;
        int expected = 0;
        assertEquals("The integers after rounding down doesn't match", expected, roundUtil.roundDown(test));
        int test2 = 14;
        int expected2 = 10;
        assertEquals("The integers after rounding down doesn't match", expected2, roundUtil.roundDown(test2));
        int test3 = 0;
        int expected3 = 0;
        assertEquals("The integers after rounding down doesn't match", expected3, roundUtil.roundDown(test3));
    }
    @Test
    public void testRoundUpFromTopValue5To9(){
        int test1 = 19;
        int expected1 = 20;
        assertEquals("The integers after rounding up doesn't match", expected1, roundUtil.roundUp(test1));
        int test2 = 9;
        int expected2 = 10;
        assertEquals("The integers after rounding up doesn't match", expected2, roundUtil.roundUp(test2));
        int test3 = 5;
        int expected3 = 10;
        assertEquals("The integers after rounding up doesn't match", expected3, roundUtil.roundUp(test3));
    }
    @Test
    public void testRoundUpFromBottomValue0To4(){
        int test1 = 10;
        int expected1 = 15;
        assertEquals("The integers after rounding up doesn't match", expected1, roundUtil.roundUp(test1));
        int test2 = 0;
        int expected2 = 0;
        assertEquals("The integers after rounding up doesn't match", expected2, roundUtil.roundUp(test2));
        int test3 = 4;
        int expected3 = 5;
        assertEquals("The integers after rounding up doesn't match", expected3, roundUtil.roundUp(test3));
        int test4 = 14;
        int expected4 = 15;
        assertEquals("The integers after rounding up doesn't match", expected4, roundUtil.roundUp(test4));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRoudUp_BadTypeOfNumberIsEntered_ExceptionIsThrown() {
        int badNumber = -1;

        roundUtil.roundUp(badNumber);
    }
}