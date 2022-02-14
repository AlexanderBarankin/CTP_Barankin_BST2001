/*
Класс Primes используется для решения задачи 1. Простые числа.
В данном классе используются методы, которые находят и выводят простые числа, меньшие 100.
 */
public class Primes {
    public static void main(String[] args){ //В методе main() находятся простые числа < 100 при помощи метода isPrime()
        for (int i = 2; i <= 100; i++){
            if (isPrime(i))
                System.out.println(i + " is prime number");
        }
    }
    public static boolean isPrime(int n){ //Метод isPrime() определяет, является ли число простым
        boolean isPrime = true;
        for (int i = 2; i < n; i++){
            if ((n % i) == 0)
                isPrime = false;
        }
        return isPrime;
    }
}