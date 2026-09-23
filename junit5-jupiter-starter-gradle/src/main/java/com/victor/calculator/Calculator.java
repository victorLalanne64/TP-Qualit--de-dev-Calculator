package com.victor.calculator;

public class Calculator {

    public static int add(int opG, int opD) {
        long result = (long) opG + (long) opD;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Dépassement de capacité pour un int");
        }
        return (int) result;
    }

    public static int divide(int opG, int opD) {
        return opG / opD;
    }
}