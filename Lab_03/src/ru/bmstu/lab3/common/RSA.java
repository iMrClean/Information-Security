package ru.bmstu.lab3.common;

import java.math.BigInteger;
import java.security.SecureRandom;

import static java.math.BigInteger.ONE;

public class RSA {

    private static final SecureRandom RANDOM = new SecureRandom();
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    public RSA(int n) {
        // p и q - взаимно простые числа
        BigInteger p = BigInteger.probablePrime(n / 2, RANDOM);
        BigInteger q = BigInteger.probablePrime(n / 2, RANDOM);
        // Модуль n = p * q
        this.n = p.multiply(q);
        // Функция Эйлера f(n) = (p - 1) * (q - 1)
        BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));
        // простые из чисел Ферма: 17, 257 или 65537, так как в этом случае время, необходимое для шифрования с использованием быстрого возведения в степень будет меньше.
        e = new BigInteger("65537");
        //Вычисляется число d, мультипликативно обратное к числу  e по модулю f(n).
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

}
