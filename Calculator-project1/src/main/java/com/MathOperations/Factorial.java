package main.java.com.MathOperations;

import java.math.BigInteger;

public class Factorial {

    public BigInteger fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial of negative number is undefined");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

   
}
