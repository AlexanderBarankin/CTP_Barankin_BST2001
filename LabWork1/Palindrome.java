/*
Класс Palindrome используется для решения задачи 2. Палиндромы.
В данном классе используются методы, которые определяют, являются ли введённые слова палиндромами.
 */
public class Palindrome {
    //В методе main() происходит определение: слово - палиндром или нет
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String str = args[i];
            if (isPalindrome(str))
                System.out.println(str + " is a palindrome");
            else
                System.out.println(str + " is not a palindrome");
        }
    }
    //Метод reverseString() позволяет переписать введённое слово наоборот
    public static String reverseString(String str){
        String reverseString = "";
        for (int i = str.length() -1; i >= 0; i--){
            reverseString += str.charAt(i);
        }
        return reverseString;
    }
    //Метод isPalindrome() задействует reverseString() для проверки слова. Является ли оно палиндромом
    public static boolean isPalindrome(String str){
        if (str.equals(reverseString(str)))
            return true;
        else
            return false;
    }
}
