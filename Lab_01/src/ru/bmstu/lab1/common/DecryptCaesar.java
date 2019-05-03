package ru.bmstu.lab1.common;

public class DecryptCaesar extends Caesar {

    private int key;

    private String decText;

    public DecryptCaesar(String text, int key) {
        this.key = key;
        StringBuilder dec = getText(text, key);
        this.decText = dec.toString();
    }

    public int getKey() {
        return key;
    }

    public String getDecText() {
        return decText;
    }

    private StringBuilder getText(String text, int key) {
        StringBuilder dec = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char _char = text.charAt(i);

            if (isRussian(_char)) {
                int correctChar = (findInRussian(_char) - key + nRus) % nRus;

                if (Character.isUpperCase(_char)) {
                    dec.append(russian[correctChar]);

                } else {
                    dec.append(Character.toLowerCase(russian[correctChar]));
                }
            } else if (isNumber(_char)) {
                int correctChar = (findInNumbers(_char) - key + nNumbers) % nNumbers;

                dec.append(numbers[correctChar]);
            } else {
                dec.append(_char);
            }
        }
        return dec;
    }
}
