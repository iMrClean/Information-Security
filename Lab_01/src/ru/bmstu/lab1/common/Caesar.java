package ru.bmstu.lab1.common;

public abstract class Caesar {

    /**
     * Количество букв алфавита
     */
    protected final int nRus = 33;

    /**
     * Количество цифр
     */
    protected final int nNumbers = 10;

    protected char[] russian = {
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф',
            'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
    };

    protected char[] numbers = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    public int findInRussian(char c) {
        int result = -1;

        for (int i = 0; i < russian.length; i++) {
            if (Character.toUpperCase(c) == russian[i])
                result = i;
        }
        return result;
    }

    public int findInNumbers(char c) {
        int result = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (Character.toUpperCase(c) == numbers[i])
                result = i;
        }
        return result;
    }

    /**
     * 1105 и 1025 - коды буквы ё и Ё
     *
     * @param c символ
     * @return является ли символ русским
     */
    public boolean isRussian(char c) {
        int i = (int) c;

        return i >= 1040 && i <= 1103 || i == 1105 || i == 1025;
    }

    /**
     * @param c символ
     * @return является ли символ числом
     */
    public boolean isNumber(char c) {
        int i = (int) c;

        return i >= 48 && i <= 57;
    }
}
