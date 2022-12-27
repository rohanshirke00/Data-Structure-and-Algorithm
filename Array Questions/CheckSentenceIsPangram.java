
// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

import java.util.Scanner;
public class CheckSentenceIsPangram {

    //method 1
    public static boolean checkIfPangram(String sentence) {

        if(sentence.length()<26) return false;
    
        boolean[] arr = new boolean[26];
    
        for(int i=0; i<sentence.length(); i++){
            arr[sentence.charAt(i)-97] = true;
        }
        for(int i=0; i<26; i++){
            if(arr[i] == false) return false;
        }
        return true;
    
    }
    

    /*
     
    //method 2
    public static boolean checkIfPangram(String sentence) {
        
        if(sentence.length()<26) return false;
        
        int res = 0;
        
        for(int i=0; i<sentence.length(); i++){
            res = res | (1 << (sentence.charAt(i) - 97));
            if(res == (1<<26) -1) return true;
        }
        return false;
        
    }
    
    */


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String sentence = sc.nextLine();

        if(checkIfPangram(sentence))
        {
            System.out.println("Entered sentence is pangram");
        }
        else
        {
            System.out.println("Entered sentence is not pangram");
        }
    }
}
