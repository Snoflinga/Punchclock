package com.company;

/**
 * Created by jgrahn on 2017-06-01.
 */
public class Saldo {
    private long saldo;

    public void Saldo() {
        saldo = 0;
    }

    public long getSaldo() {
        return saldo;
    }

    public void changeSaldo(long i) {
        this.saldo = this.saldo + i;
    }
}
