package ru.bmstu.lab1;

import ru.bmstu.lab1.common.DecryptCaesar;
import ru.bmstu.lab1.common.EncryptCaesar;

import java.util.Scanner;

/**
 * Лабораторная работа №1
 * <p>
 * Строка на вход.
 * Шифр/дешифр Цезаря.
 * Буквы и цифры.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите любое слово или фразу: ");
        String text = sc.nextLine();
        System.out.println("1 - Зашифровать 2 - Дешифровать:");
        int number = sc.nextInt();

        if (number < 1 || number > 2) {
            System.out.println("Неверное число");
            System.exit(-1);
        }

        if (number == 1) {
            EncryptCaesar enc = new EncryptCaesar(text, 8);
            System.out.println(enc.getEncText());
        }

        if (number == 2) {
            DecryptCaesar dec = new DecryptCaesar(text, 8);
            System.out.println(dec.getDecText());
        }
    }
}
