package kurs;

/*
Привет. Сегодня пишем шифратор и дешифратор текста :)
Работать будем только с английским. Следовательно, буквы будут использоваться только английского словаря.
Надо написать две функции.
Первая должна получать на вход строку и шифровать ее по следующему принципу - каждая буква заменяется
на следующую в алфавите, при этом большая буква становится маленькой, а маленькая - большой.
То есть "a" заменяется на "B", а "X" заменяется на "z". Последняя буква заменяется на первую,
то есть "Z" на "a", а "z" на "A". Итоговая строка возвращается.
Вторая функция должна расшифровывать строку, соответственно действовать наоборот.
*/

public class Main {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String inText = "Your own portfolio website to showcase your work and get hired";
        String scrambledText = scrambler(inText);
        String decodedText = decoder(scrambledText);
        System.out.printf("in = %s\n", inText);
        System.out.printf("scrambled = %s\n", scrambledText);
        System.out.printf("decoded = %s\n", decodedText);
        System.out.printf("decoded.equals(in) = %s\n", decodedText.equals(inText) ? "true" : "false");
    }

    private static String scrambler(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char cLower = Character.toLowerCase(c);
            int p = LETTERS.indexOf(cLower);
            if (p == -1)
                sb.append(c);
            else {
                if (p == LETTERS.length() - 1)
                    p = 0;
                else
                    p++;
                char cOut = LETTERS.charAt(p);
                if (c == cLower)
                    sb.append(Character.toUpperCase(cOut));
                else
                    sb.append(cOut);
            }
        }
        return sb.toString();
    }

    private static String decoder(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char cLower = Character.toLowerCase(c);
            int p = LETTERS.indexOf(cLower);
            if (p == -1)
                sb.append(c);
            else {
                if (p == 0)
                    p = LETTERS.length() - 1;
                else
                    p--;
                char cOut = LETTERS.charAt(p);
                if (c == cLower)
                    sb.append(Character.toUpperCase(cOut));
                else
                    sb.append(cOut);
            }
        }
        return sb.toString();
    }
}
