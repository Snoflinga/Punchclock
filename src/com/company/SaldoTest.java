package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jgrahn on 2017-06-01.
 */
public class SaldoTest {
    private Saldo saldo;

    @Before
    public  void setUp() {
        saldo = new Saldo();
    }
    @Test
    public void testGetSaldo(){
        long actual = saldo.getSaldo();
        long expected = 0;
        assertEquals("Saldo isn't correct", expected, actual);
    }
    @Test
    public void testChangSaldoPositive(){
        saldo.changeSaldo(13);
        long actual = saldo.getSaldo();
        long expected = 13;
        assertEquals("Saldo isn't correct", expected, actual);
    }
    @Test
    public void testChangeSaldoNegative(){
        saldo.changeSaldo(-13);
        long actual = saldo.getSaldo();
        long expected = -13;
        assertEquals("Saldo isn't correct", expected, actual);
    }

}