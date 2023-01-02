
// https://leetcode.com/problems/find-the-duplicate-number/
// https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/

import java.util.Arrays;

public class FindDuplicateInArray{
    public static void main(String[] args) {
        int A[] = {1,3,4,5,4,2};

        //solution 1:
        System.out.println(findDuplicate(A));
        
        //solution 2:
        System.out.println(findDuplicate1(A));
        
    }

    
    /*

        solution 1 : Using sorting, T >> O(Nlongn + n),  S >> O(1)

        Approach: Sort the array. After that, if there is any duplicate number they will be adjacent.
        So we simply have to check if arr[i]==arr[i+1] and if it is true,arr[i] is the duplicate number.

    */
    public static int findDuplicate(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length-1; i++) {
            if(A[i] == A[i+1]) return A[i];
        }
        return A.length;
    }
    

    /*
 
        solution 2 : Using sorting, T >> O(n),  S >> O(n)
        
        Approach: Take a frequency array of size N+1 and initialize it to 0. 
        Now traverse through the array and if the frequency of the element is 0 increase it by 1,
        else if the frequency is not 0 then that element is the required answer.
        
    */
    public static int findDuplicate1(int [] A) {
        int[] frequency =  new int[A.length];
        for (int i = 0; i < frequency.length; i++) {
            if(frequency[A[i]] == 0){
                frequency[A[i]]++;
            }
            else{
                return A[i];
            }
        }
        return A.length;
    }

}