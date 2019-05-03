package ru.bmstu.lab1.common;

public class EncryptCaesar extends Caesar{

    private int key;

    private String encText;

    public EncryptCaesar(String text, int key) {
        this.key = key;
        StringBuilder enc = getText(text, key);
        this.encText = enc.toString();
    }

    public int getKey() {
        return this.key;
    }

    public String getEncText() {
        return this.encText;
    }

    private StringBuilder getText(String text, int key) {
        StringBuilder enc = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char _char = text.charAt(i);

            if (isRussian(_char)) {
                int correctChar = (findInRussian(_char) + key) % nRus;

                if (Character.isUpperCase(_char)) {
                    enc.append(russian[correctChar]);

                } else {
                    enc.append(Character.toLowerCase(russian[correctChar]));
                }
            } else if (isNumber(_char)) {
                int correctChar = (findInNumbers(_char) + key) % nNumbers;

                enc.append(numbers[correctChar]);
            } else {
                enc.append(_char);
            }
        }
        return enc;
    }
}
