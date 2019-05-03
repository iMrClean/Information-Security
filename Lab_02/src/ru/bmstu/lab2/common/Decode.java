package ru.bmstu.lab2.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Decode {

    public static String decodeMessage(String message) {
        StringBuilder result = new StringBuilder();
        Arrays.stream(message
                .split("(?<=\\G.{8})"))
                .forEach(
                        s -> result
                                .append(
                                        (char) Integer.parseInt(s, 2)
                                )
                );
        return result.toString();
    }

    public static String getMessageFromImage(BufferedImage image) {
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color c = new Color(image.getRGB(x, y));
                byte r = (byte) c.getRed();
                byte g = (byte) c.getGreen();
                byte b = (byte) c.getBlue();
                byte[] RGB = {r, g, b};

                for (int i = 0; i < 3; i++) {
                    if ((RGB[i] & 1) == 1) {
                        result.append("1");
                    } else {
                        result.append("0");
                    }
                }
            }
        }

        return result.toString();
    }
}