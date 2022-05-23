package com.company;

import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static java.lang.String.valueOf;

public class Main {

    public static void main(String[] args) {

        // Task 1
        System.out.println("=== Task 1 ===");
        int townsNumber = 14;

        Object[] town = new Object[14];

        town[0] = "Nice";
        town[1] = 942208;
        town[2] = "Abu Dhabi";
        town[3] = 1482816;
        town[4] = "Naples";
        town[5] = 2186853;
        town[6] = "Vatican City";
        town[7] = 572;
        town[8] = "Manila";
        town[9] = 13923452;
        town[10] = "Kuala Lumpur";
        town[11] = 7996830;
        town[12] = "Jakarta";
        town[13] = 10770487;

        for (int i = 0; i < townsNumber; i++) {
            if (i % 2 != 0) {
                System.out.println(town[i - 1]);
                int temp = (int) town[i];
                town[i] = millionsRounding(temp);
                String result = "" + town[i];
                System.out.println(result);
            }
        }

        System.out.println(" ");

        // Task 2
        System.out.println("=== Task 2 ===");

        double smallSide = 1;
        double[] otherSides = new double[2];

        otherSides[0] = 2 * smallSide;
        otherSides[1] = round(Math.sqrt(3) * smallSide, otherSides.length);

        System.out.println(Arrays.toString(otherSides));

        System.out.println(" ");

        // Task 3
        System.out.println("=== Task 3 ===");

        String[] rsp = {"rock", "scissors"};

        System.out.println(" Player " + checkWinner(rsp) + " wins!");

        System.out.println(" ");

        // Task 4
        System.out.println("=== Task 4 ===");

        int[] warOfNumbers = {1, 7, 9, 3, 13, 6, 8, 12, 14, 2};

        System.out.println(warWinner(warOfNumbers) + " numbers won the war!");

        System.out.println(" ");

        // Task 5
        System.out.println("=== Task 5 ===");

        String str = "We greet you";

        System.out.println(reverseCase(str));

        System.out.println(" ");

        // Task 6
        System.out.println("=== Task 6 ===");

        String obj = "Burger";
        int num = obj.length();

        System.out.println(obj + "inator " + num + "000");

        System.out.println(" ");

        // Task 7
        System.out.println("=== Task 7 ===");

        int[] brick = {1, 2, 1};
        int[] hole = {1, 1};

        System.out.println(putTheBrick(brick, hole));

        System.out.println(" ");

        // Task 8
        System.out.println("=== Task 8 ===");

        double fuel = 36.1;
        double consumption = 8.6;
        int passengers = 3;
        boolean conditioning = true;

        String result = String.format("%.2f", totalDistance(fuel, consumption, passengers, conditioning));
        System.out.println(result);

        System.out.println(" ");

        // Task 9
        System.out.println("=== Task 9 ===");

        int[] numbers = {1, 56, 32, 7, 89, 123};

        result = String.format("%.2f", average(numbers));
        System.out.println(result);

        System.out.println(" ");

        // Task 10
        System.out.println("=== Task 10 ===");

        num = 243;
        System.out.println(checkMyNumber(num));

        System.out.println(" ");

        // Task 11
        System.out.println("=== Task 11 ===");

        int[] newNumbers = {1, 4, 7, 9, 2};

        System.out.println(boomFunction(newNumbers));

        System.out.println(" ");

        // Task 12
        System.out.println("=== Task 12 ===");

        int[] newNewNumbers = {1, 4, 2, 3, 4};

        System.out.println(arrangeTo(newNewNumbers));

        System.out.println(" ");

        // Task 13
        System.out.println("=== Task 13 ===");

        String s = "badce";

        System.out.println(unMix(s));

        System.out.println(" ");

        //Task 14
        System.out.println("=== Task 14 ===");

        String question = "I just!!! can!!! not!!! believe!!! it!!!";

        System.out.println(lessSigns(question));

        System.out.println(" ");

        // Task 15
        System.out.println("=== Task 15 ===");

        String newS = "OMG x box unboxing video x D";

        System.out.println(changeX(newS));

        System.out.println(" ");

        // Task 16
        System.out.println("=== Task 16 ===");

        int[] numbersAgain = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};

        System.out.println(largestGap(numbersAgain));

        System.out.println(" ");

        // Task 17
        System.out.println("=== Task 17 ===");

        int n = 832;

        System.out.println(minusMe(n));

        System.out.println(" ");

        // Task 18
        System.out.println("=== Task 18 ===");

        String string = "OOI UUI EEI AAI";

        System.out.println(commonLastVowel(string));

        System.out.println(" ");

        // Task 19
        System.out.println("=== Task 19 ===");

        int a = 248;
        int b = 208;

        System.out.println(memeSum(a, b));

        System.out.println(" ");

        // Task 20
        System.out.println("=== Task 20 ===");

        String checkMySigns = "teshahset";

        System.out.println(noRepeats(checkMySigns));

        System.out.println(" ");

    }
    // Help Methods


    // For Task 1
    public static int millionsRounding(int t) {
        if (t % 1000000 >= 500000)
            t = (((t / 1000000 + 1) * 1000000));
        else
            t = (((t / 1000000) * 1000000));
        return t;
    }

    // For Task 3
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // For Task 4
    private static int checkWinner(String[] array) {
        int winner = 2;
        if (((Objects.equals(array[0], "rock")) && (Objects.equals(array[1], "scissors"))) ||
                ((Objects.equals(array[0], "scissors")) && (Objects.equals(array[1], "paper"))) ||
                ((Objects.equals(array[0], "paper")) && (Objects.equals(array[1], "rock"))))

            winner = 1;
        if (Objects.equals(array[0], array[1]))
            winner = 0;
        return winner;
    }

    // For Task 5
    private static String warWinner(int[] array) {
        int oddSum = 0;
        int evenSum = 0;

        for (int j : array) {
            if (j % 2 != 0)
                oddSum += j;
            else
                evenSum += j;
        }

        if (oddSum > evenSum)
            return "Odd";
        else
            return "Even";
    }

    // For Task 6
    public static String reverseCase(String s) {
        char[] chars = s.toCharArray();

        StringBuilder sBuilder = new StringBuilder();
        for (char aChar : chars) {
            String temp = valueOf(aChar);
            if (temp.equals(temp.toLowerCase()))
                sBuilder.append(temp.toUpperCase());
            else
                sBuilder.append(temp.toLowerCase());
        }
        s = sBuilder.toString();

        return s;
    }

    // For Task 7
    public static boolean putTheBrick(int[] brick, int[] hole) {
        return ((brick[0] <= hole[0]) && (brick[1] <= hole[1])) ||
                ((brick[1] <= hole[0]) && (brick[0] <= hole[1])) ||
                ((brick[2] <= hole[0]) && (brick[0] <= hole[1])) ||
                ((brick[0] <= hole[0]) && (brick[2] <= hole[1])) ||
                ((brick[1] <= hole[0]) && (brick[2] <= hole[1])) ||
                ((brick[2] <= hole[0]) && (brick[1] <= hole[1]));
    }

    // For Task 8
    public static double totalDistance(double fuel, double consumption, int passengers, boolean conditioning) {
        consumption += passengers * (consumption * 0.05);
        if (conditioning)
            consumption += consumption * 0.1;
        return (fuel / consumption) * 100;
    }

    // For Task 9
    public static double average(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum / (double) array.length;
    }

    // For Task 10
    public static boolean checkMyNumber(int num) {
        int sum = 0;
        int compare = num;
        String temp = valueOf(num);
        for (int i = 0; i < temp.length(); i++) {
            sum += (num % 10);
            num -= (num % 10);
            num /= 10;
        }

        System.out.println("Number = " + compare);
        System.out.println("Sum of digits == " + sum);
        return (compare % 2) == (sum % 2);
    }

    // For Task 11
    public static String boomFunction(int[] array) {
        for (int j : array) {
            if (j == 7) {
                return "BOOM!";
            }
        }
        return "There is no 7 in this array";
    }

    // For Task 12
    public static boolean arrangeTo(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] != 1)
                return false;
        }
        return true;
    }

    // For Task 13
    public static String unMix(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            char temp = chars[i - 1];
            chars[i - 1] = chars[i];
            chars[i] = temp;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str.append(chars[i]);
        }
        return str.toString();
    }

    // For Task 14
    public static String lessSigns(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        int signs = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            String q = valueOf(chars[i]);
            if ((Objects.equals(q, "?")) || (Objects.equals(q, "!")))
                signs += 1;
            else
                break;
        }

        for (int i = 0; i < s.length() - signs + 1; i++) {
            str.append(chars[i]);
        }

        return str.toString();
    }

    // For Task 15
    public static String changeX(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String q = valueOf(chars[i]);

            if (Objects.equals(q, "x")) {
                String p = valueOf(chars[i + 1]);
                String g = valueOf(chars[i - 1]);

                if (((Objects.equals(p, " ")) && (Objects.equals(g, " "))) ||
                        ((i == s.length() - 1) && (!Objects.equals(g, " "))))
                    str.append("ecks");
                else
                    str.append("z");
            } else
                str.append(q);
        }

        return str.toString();
    }

    // For Task 16
    public static int largestGap(int[] array) {
        Arrays.sort(array);
        int max = -9999999;

        for (int i = 1; i < array.length; i++) {
            if ((array[i] - array[i - 1]) > max)
                max = (array[i] - array[i - 1]);
        }
        return max;
    }

    // For Task 17
    public static int minusMe(int a) {
        String s = valueOf(a);
        int l = (s).length();

        char[] chars = s.toCharArray();

        StringBuilder str = new StringBuilder();

        for (int i = l - 1; i >= 0; i--) {
            str.append(chars[i]);
        }

        int b = Integer.parseInt(str.toString());

        return a - b;
    }

    // For Task 18
    public static String commonLastVowel(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        int vow = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            String ch1 = valueOf(chars[i]);
            String ch2 = valueOf(chars[i + 1]);

            if ((Objects.equals(ch2, "")) || (i == s.length() - 2)) {
                if ((Objects.equals(ch1, "e")) ||
                        (Objects.equals(ch1, "y")) ||
                        (Objects.equals(ch1, "u")) ||
                        (Objects.equals(ch1, "i")) ||
                        (Objects.equals(ch1, "o")) ||
                        (Objects.equals(ch1, "a")))
                    vow += 1;
            }
        }

        char[] lastVowels = new char[vow];

        for (int i = 0; i < s.length() - 1; i++) {
            String ch1 = valueOf(chars[i]);
            String ch2 = valueOf(chars[i + 1]);

            int ind = -1;

            if ((Objects.equals(ch2, "")) || (i == s.length() - 2)) {
                if ((Objects.equals(ch1, "e")) ||
                        (Objects.equals(ch1, "y")) ||
                        (Objects.equals(ch1, "u")) ||
                        (Objects.equals(ch1, "i")) ||
                        (Objects.equals(ch1, "o")) ||
                        (Objects.equals(ch1, "a"))) {
                    ind += 1;
                    lastVowels[ind] = chars[i];
                }
            }
        }

        String[] letters = {"e", "y", "u", "i", "o", "a"};
        int[] numbers = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < vow; i++) {
            String ch = valueOf(lastVowels[i]);

            if (Objects.equals(ch, "e"))
                numbers[0] += 1;
            if (Objects.equals(ch, "y"))
                numbers[1] += 1;
            if (Objects.equals(ch, "u"))
                numbers[2] += 1;
            if (Objects.equals(ch, "i"))
                numbers[3] += 1;
            if (Objects.equals(ch, "o"))
                numbers[4] += 1;
            if (Objects.equals(ch, "a"))
                numbers[5] += 1;
        }

        int max = 0;
        int ind = 0;

        for (int i = 0; i < vow; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                ind = i;
            }
        }

        str.append(letters[ind]);

        return str.toString();
    }

    // For Task 19
    public static int memeSum(int num1, int num2) {
        StringBuilder str = new StringBuilder();

        String s1 = valueOf(num1);
        String s2 = valueOf(num2);

        int n1 = (s1).length();
        int n2 = (s2).length();

        int mod1 = (int) Math.pow(10, n1);
        int mod2 = (int) Math.pow(10, n2);

        if (n1 > n2) {
            int checker = mod1;
            for (int i = n1 - 1; i >= 0; i--) {
                str.append(((num1 % checker - num1 % (checker / 10)) +
                        (num2 % checker - num2 % (checker / 10))) / (checker / 10));
                checker /= 10;
            }
        } else {
            int checker = mod2;
            for (int i = n2 - 1; i >= 0; i--) {
                str.append(((num1 % checker - num1 % (checker / 10)) +
                        (num2 % checker - num2 % (checker / 10))) / (checker / 10));
                checker /= 10;
            }
        }

        return Integer.parseInt(str.toString());
    }

    // For Task 20
    public static String noRepeats(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        char[] check = new char[s.length()];

        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                check[0] = chars[0];
                str.append(chars[0]);
            } else {
                for (int j = 0; j < i; j++) {
                    if (check[j] == chars[i]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    str.append(chars[i]);
                    check[i] = chars[i];
                }
            }
        }
        return str.toString();
    }
}

//import java.util.Scanner;
//
//public class Program {
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int num = in.nextInt();
//
//        System.out.printf("Your number: %d \n", num);
//        in.close();
//    }
//}

//public class Palindrome {
//    //В методе main() происходит определение: слово - палиндром или нет
//    public static void main(String[] args) {
//        for (int i = 0; i < args.length; i++) {
//            String str = args[i];
//            if (isPalindrome(str))
//                System.out.println(str + " is a palindrome");
//            else
//                System.out.println(str + " is not a palindrome");
//        }
//    }
