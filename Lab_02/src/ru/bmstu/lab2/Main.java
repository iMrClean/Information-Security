package ru.bmstu.lab2;

import ru.bmstu.lab2.common.Decode;
import ru.bmstu.lab2.common.Encode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Лабораторная работа №2
 * Реализовать шифратор\дешифратор внедряющий сообщение в файлы.(Стеганография)
 */
public class Main {

    private static final String PATH = "src\\resources\\";

    private static final String FILE_NAME = "image.bmp";

    private static final String NEW_FILE_NAME = "test.bmp";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение для кодирования:");
        String message = scanner.nextLine();
        String bitMessage = Encode.encodeMessage(message);
        System.out.println("Bit message: " + bitMessage);

        BufferedImage initImage = ImageIO.read(new File(PATH + FILE_NAME));
        BufferedImage encodedImage = Encode.encodeImage(bitMessage, initImage);
        ImageIO.write(encodedImage, "bmp", new File(PATH + NEW_FILE_NAME));
        System.out.println("Файл успешно сохранен");

        System.out.println("Декодируем сообщения из картинки");
        String messageFromImage = Decode.getMessageFromImage(encodedImage);
        System.out.println("Decode message: " + Decode.decodeMessage(messageFromImage));
    }
}
