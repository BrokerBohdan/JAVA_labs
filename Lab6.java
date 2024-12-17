import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab6 {

       // Метод для перетворення рядка з вісімковим числом у десяткове ціле число
       public static int octStringToInt(String s) {
        return Integer.parseInt(s, 8); // Використовуємо основу 8 для конвертації
    }

    // Метод для підрахунку кількості комбінацій літер і цифр у реченні
    public static int countLetterDigitCombinations(String sentence) {
        // Регулярний вираз для знаходження слів, які містять і літери, і цифри
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9]*[a-zA-Z]+[0-9]+[a-zA-Z0-9]*\\b|\\b[a-zA-Z0-9]*[0-9]+[a-zA-Z]+[a-zA-Z0-9]*\\b");
        Matcher matcher = pattern.matcher(sentence);
        int count = 0;

        // Підраховуємо всі збіги
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Приклад використання методу octStringToInt
        String octalNumber = "777";
        int decimalResult = octStringToInt(octalNumber);

        System.out.println("Вісімкове число: " + octalNumber);
        System.out.println("Десяткове число: " + decimalResult);

        // Приклад використання методу countLetterDigitCombinations
        String sentence = "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
        int combinationsCount = countLetterDigitCombinations(sentence);

        System.out.println("Речення: " + sentence);
        System.out.println("Кількість комбінацій літер та цифр: " + combinationsCount);
    }
}