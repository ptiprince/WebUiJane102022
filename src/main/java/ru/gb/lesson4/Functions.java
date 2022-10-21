package ru.gb.lesson4;

public class Functions {
    public static double areaGeron(double side1, double side2, double side3) throws WrongTriangleException {
        if (side1<=0 || side2<=0 || side3<=0 || (side1 + side2) < side3 ||
                (side1 + side3) < side2 || (side3 + side2) < side1) throw new WrongTriangleException();
        double p = (side1 + side2 + side3) / 2;
        double s = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return s;
    }

    public static boolean isNumberEven(Integer number) {
        return number % 2 == 0;
    }

    public boolean isNumberPositive(Integer number) {
        return number > 0;
    }

    public boolean isPrime(Integer number) {
        if (number < 0) return false;
        if (number == 1) return true;
        if (number == 2) return true;
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        return isPalindrome(word.substring(1, word.length() - 1));
    }
}


