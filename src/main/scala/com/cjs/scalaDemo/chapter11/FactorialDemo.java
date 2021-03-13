package com.cjs.scalaDemo.chapter11;

import java.math.BigInteger;

public class FactorialDemo {
    public static BigInteger fac(BigInteger number){
        if(number.equals(BigInteger.valueOf(0))) return BigInteger.valueOf(1);
        else return number.multiply(fac(number.subtract(BigInteger.valueOf(1))));
    }

    public static void main(String[] args) {
        BigInteger bigInteger = fac(BigInteger.valueOf(100000));
        System.out.println(bigInteger);
    }
}
