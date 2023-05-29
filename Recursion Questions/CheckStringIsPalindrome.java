

// https://www.geeksforgeeks.org/string-palindrome/
// https://www.geeksforgeeks.org/sentence-palindrome-palindrome-removing-spaces-dots-etc/


import java.util.Scanner;

public class CheckStringIsPalindrome {

    /*
    // approach 1 : simple palindrome containg only letter

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String containing (A-Z, 0-9) charaters : ");
        String str = sc.nextLine();
        System.out.print("isPalindrome : " + isPalindrome(str,0,str.length()));
        sc.close();
    }

    public static boolean isPalindrome(String str, int i, int n) {

        if (i >= n / 2) {
            return true;
        }
        if (str.charAt(i) != str.charAt(n - i - 1)) {
            return false;
        }
        return isPalindrome(str, ++i, n);
    }

    */




    


    // approachc 2 : palindrome containg all specical character

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String containing (A-Z, 0-9) charaters : ");
        String str = sc.nextLine();
        System.out.println("isPalindrome : " + isPalindrome(str));
        sc.close();
    }


    public static boolean isPalindrome(String s) {

        String str = s.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.replaceAll("\\s", "");
        int i = 0;
        int n = str.length();
        if (checkPalindrome(str, i, n)) {
            return true;
        }
        return false;

    }

    public static boolean checkPalindrome(String str, int i, int n) {

        if (i >= n / 2) {
            return true;
        }
        if (str.charAt(i) != str.charAt(n - i - 1)) {
            return false;
        }

        return checkPalindrome(str, ++i, n);
    }

}
