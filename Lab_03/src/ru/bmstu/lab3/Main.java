package ru.bmstu.lab3;

import ru.bmstu.lab3.common.RSA;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Лабораторная работа №3
 * Реализовать алгоритм RSA шифратор\дешифратор
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для зашифровки");
        String text = scanner.nextLine();
        System.out.println("Введите размер RSA");
        int N = scanner.nextInt();
        RSA key = new RSA(N);

        BigInteger encrypt = key.encrypt(new BigInteger(text.getBytes()));
        System.out.println("Encrypt: " + encrypt);

        BigInteger decrypt = key.decrypt(encrypt);
        System.out.println("Decrypt: " + new String(decrypt.toByteArray()));
    }
}
