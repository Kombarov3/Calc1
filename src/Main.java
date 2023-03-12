import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);
    static int num1;
    static int num2;
    static int result;
    static boolean isRoman;
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Введите выражение:");
            String input = inputScanner.nextLine();
            System.out.println(calc(input));
        }

    }

    public static String calc(String input) throws Exception {
        String[] numbers = input.split("[+*/-]");
        if (numbers.length == 1) {
            throw new Exception("строка не является математической операцией");
        } else if (numbers.length != 2) {
            throw new Exception("формат математической операции - два операнда и один оператор (+, -, /, *)");

        }
        if (isRoman(numbers[0]) && isRoman(numbers[1])) {
            num1 = convertToArabian(numbers[0]);
            num2 = convertToArabian(numbers[1]);
            isRoman = true;
        } else if (!isRoman(numbers[0]) && !isRoman(numbers[1])) {
            num1 = Integer.parseInt(numbers[0]);
            num2 = Integer.parseInt(numbers[1]);
            isRoman = false;
        } else {
            throw new Exception("используются одновременно разные системы исчисления");
        }
        if (!isRoman) {
            if ((num1 <= 10 && num2 <= 10) && (num1 > 0 && num2 > 0)) {
                if (input.contains("+")) {
                    result = num1 + num2;
                } else if (input.contains("*")) {
                    result = num1 * num2;
                } else if (input.contains("/")) {
                    result = num1 / num2;
                } else if (input.contains("-")) {
                    result = num1 - num2;
                }
                return Integer.toString(result);
            } else {
                throw new Exception("Число должно быть меньше или равно 10");
            }
        } else {
            if (isRoman) {
                if (num1 > 0 && num2 > 0) {
                    if (num1 <= 10 && num2 <= 10) {
                        if (input.contains("+")) {
                            result = num1 + num2;
                        } else if (input.contains("*")) {
                            result = num1 * num2;
                        } else if (input.contains("/")) {
                            result = num1 / num2;
                        } else if (input.contains("-")) {
                            result = num1 - num2;
                        }if (result <= 0) {
                            throw new Exception("в римской системе исчислений нет нуля и отрицательных чисел");
                        }
                       return convertToRoman(result);
                    } else {
                        throw new Exception("Число должно быть меньше или равно 10");
                    }
                }
                
            }
        }
        return Integer.toString(result);
    }

    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}



