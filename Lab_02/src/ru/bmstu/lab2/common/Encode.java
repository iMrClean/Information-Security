package ru.bmstu.lab2.common;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Encode {

    public static String encodeMessage(String message) {
        StringBuilder result = new StringBuilder();
        int bits = 8;
        String binString;
        int length;
        char[] charArray = message.toCharArray();

        for (char c : charArray) {
            binString = Integer.toBinaryString(c);
            length = binString.length();
            if (length != bits) {
                length = bits - length;
                if (length == bits) {
                    result.append(binString);
                } else if (length > 0) {
                    for (int j = 0; j < length; j++) {
                        result.append("0");
                    }
                    result.append(binString);
                } else {
                    System.err.print("Длина символа больше 1 бита");
                    System.exit(-1);
                }
            } else {
                result.append(binString);
            }
        }

        return result.toString();
    }

    public static BufferedImage encodeImage(String message, BufferedImage image) {
        int pointer = message.length() - 1;

        for (int x = image.getWidth() - 1; x >= 0; x--) {
            for (int y = image.getHeight() - 1; y >= 0; y--) {

                Color c = new Color(image.getRGB(x, y));
                byte r = (byte) c.getRed();
                byte g = (byte) c.getGreen();
                byte b = (byte) c.getBlue();
                byte[] RGB = {r, g, b};
                byte[] newRGB = new byte[3];

                for (int i = 2; i >= 0; i--) {
                    if (pointer >= 0) {
                        int lsb;
                        if ((RGB[i] & 1) == 1) {
                            lsb = 1;
                        } else {
                            lsb = 0;
                        }

                        if (Character.getNumericValue(message.charAt(pointer)) != lsb) {
                            if (lsb == 1) {
                                newRGB[i] = (byte) (RGB[i] & ~(1));
                            } else {
                                newRGB[i] = (byte) (RGB[i] | 1);
                            }
                        } else {
                            newRGB[i] = RGB[i];
                        }
                    } else {
                        newRGB[i] = (byte) (RGB[i] & ~(1));
                    }

                    pointer--;
                }

                Color newColor = new Color(Byte.toUnsignedInt(newRGB[0]), Byte.toUnsignedInt(newRGB[1]), Byte.toUnsignedInt(newRGB[2]));
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        return image;
    }
}