import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();



        String result = calc(input);



        System.out.println("Результат: " + result);
    }

    public static String calc(String input) {


        String[] tokens = input.split(" ");
        int a, b;
        try {
            if (isRoman(tokens[0]) && isRoman(tokens[2])) {

                a = romanToArabic(tokens[0]);
                b = romanToArabic(tokens[2]);


            } else if (!isRoman(tokens[0]) && !isRoman(tokens[2])) {
                a = Integer.parseInt(tokens[0]);
                b = Integer.parseInt(tokens[2]);
            } else {
                throw new IllegalArgumentException("Введены неподходящие числа");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введены неподходящие числа");
        }


        if (a < 1 ||a > 10 ||  b < 1 ||  b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
        }

        int result;
        switch (tokens[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция");
        }

        if (isRoman(tokens[0]) && isRoman(tokens[2])) {
            if (result <= 0) {
                throw new IllegalArgumentException("Результат римской операции меньше 1");
            }
            return arabicToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    private static boolean isRoman(String s) {
        return s.equals("I") || s.equals("II")  || s.equals("III")  || s.equals("IV")||
        s.equals("V")||  s.equals("VI") || s.equals("VII") || s.equals("VIII")||
        s.equals("IX") ||  s.equals("X");
    }

    private static int romanToArabic(String s) {
        //
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    private static int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                throw new IllegalArgumentException("Неправильный символ: " + romanChar);
        }
    }

    private static String arabicToRoman(int num) {
        if (num < 1 || num > 100) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 100");
        }

        String[] romanSymbols = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"};

        return romanSymbols[num];
    }
}