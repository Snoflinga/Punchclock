package com.company;

/**
 * Created by pernilla on 2017-05-27.
 */
public class RoundUtil {
    /**
     * Rounds the last digit from an int i to the previous nearest 0 or 5.
     * @param i the whole number that you want to manipulate.
     * @return return integer rounded down.
     */
    public int roundDown(int i) {
        int lastDigit = i;

        if (lastDigit < 5 && lastDigit < 10) { // sista siffran i integern.
            return 0;
        } else if (lastDigit > 5 && lastDigit < 10){
            return 5;
        } else {
            lastDigit = i % 10;
            i = i - lastDigit;
            if (lastDigit < 5){
                return i + 0;
            } else {
                return i + 5;
            }
        }
    }

    public int roundUp(int i) {

        if (i < 0) {
            throw new IllegalArgumentException("Not a valid number:" + i);
        }

        int lastDigit = i;
        if (lastDigit == 0){
            return 0;
        } else if (lastDigit < 5 && lastDigit < 10){
            return 5;
        } else if (lastDigit > 5 && lastDigit < 10){
            return 10;
        } else {
            lastDigit = i % 10;
            i = i - lastDigit;
            if (lastDigit < 5) {
                return i + 5;
            } else {
                return i + 10;
            }
        }
    }
}
