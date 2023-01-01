
// https://leetcode.com/problems/next-permutation/
// https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/


// APPROACH
// 1) find the break point from backward (element which is just greater than the right element ) [i] index
// 2) Again find the element from the backwar which is greater than the break point element [j] index
// 3) Now swap the both elements  [swap (i,j)]
// 4) Now once we find the next permute prefix then reverse the elements o array from i+1 to end of the array
//    such that we can find the minimum permutation after the breakpoint

import java.util.Arrays;

public class NextPermutations {
    public static void main(String[] args) {
        int[] A = {1,3,2};
        System.out.print("Array : " + Arrays.toString(A));
        ngp(A);
        System.out.print("\nNext Possible permutations is : " + Arrays.toString(A));
        
    }

    static void ngp(int[] A){
        
        //checking whether array size is just 1 or not. If it simply returning the array itself
        if(A ==  null || A.length <= 1) return;

        //storing the index of 2nd last element
        int i = A.length - 2;

        // finding the break point element's index
        while(i>=0 && A[i] >= A[i+1]){
            i--;
        }

        // if we found the breakpoint index
        if(i>=0){
            int j = A.length - 1;
            // traversing from the backward to find the element whichc is just greater than the breakpoint' element
            while(A[j] <= A[i]){
                j--;
            }
            // if we found then just swap it
            swap(A , i, j);
        }
        // revering the array so that we can find the minimum permutation after the breakpoint
        reverse(A, i+1, A.length-1);

    }

    //swap function
    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //reverse function
    static void reverse(int[] A, int i, int j){
        while(i<j){
            swap(A, i++, j--);
        }
 
    }

}