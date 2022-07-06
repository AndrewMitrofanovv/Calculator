import java.util.Scanner;
import java.lang.NumberFormatException;


public class Calculator {







    public static String[] romanNumArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение, например [1 + 2] или [I + II]: ");
        String[] expSym = sc.nextLine().split(" ");
        expLenght(expSym);
        String number1 = expSym[0];
        String number2 = expSym[2];
        String operation = expSym[1];
        try {
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            int sumNumber = sum(operation, num1, num2);
            System.out.println(sumNumber);
        } catch (NumberFormatException e) {
            String sumNumber = sumNumberRom(number1, number2, operation);
            System.out.println(sumNumber);
        }
    }










    public static void expLenght(String[] a) throws Exception {
        if (a.length < 3) {
            throw new Exception("Строка не является математической операцией");
        } else if (a.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }



    public static int romanNum(String num) throws Exception {
        try {
            Roman number = Roman.valueOf(num);
            return number.getTransformation();
        } catch (IllegalArgumentException c) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
    }



    public static String sumNumberRom(String num1, String num2, String operation) throws Exception {
        String sumNumberRom = new String();
        int number1 = romanNum(num1);
        int number2 = romanNum(num2);
        int sumNumber = sum(operation, number1, number2);
        if (sumNumber > 0) {
            sumNumberRom = romanNumArray[(sumNumber) - 1];
        } else {
            throw new Exception("В римской системе нет отрицательных чисел");
        }
        return sumNumberRom;
    }



    public static int sum(String operation, int num1, int num2) throws Exception {
        int sum;
        switch (operation) {
            case "+":
                sum = num1 + num2;
                break;
            case "-":
                sum = num1 - num2;
                break;
            case "*":
                sum = num1 * num2;
                break;
            case "/":
                sum = num1 / num2;
                break;
            default:
                throw new Exception("Не верно введен арифметический оператор");
        }
        return sum;
    }
}
