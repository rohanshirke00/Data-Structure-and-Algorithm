
// https://leetcode.com/problems/merge-sorted-array/
// https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] A = {1,4,7,8,9};
        int[] B = {2,3,6,10};

        System.out.println("Before Merge ");
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        /*
        solution 1 : Brute force, T >> O(n*log(n))+O(n)+O(n), S >> O(n)
        Approach:
        
        - Make an arr3 of size n+m.
        - Put elements arr1 and arr2 in arr3.
        - Sort the arr3.
        - Now first fill the arr1 and then fill remaining elements in arr2
        */
        merge(A, B, A.length, B.length);
        

        /*
        solution 2 : Without using space, T >> O(n*m), S >> O(1)
        Approach:

        - Use a for loop in arr1.
        - Whenever we get any element in arr1 which is greater than the first element of arr2,swap it.
        - Rearrange arr2.
        - Repeat the process.
         */
        merge2(A, B, A.length, B.length);

        System.out.println("After Merge ");
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

    }


    public static void merge(int[] A, int[] B, int n, int m) {

        int k=0;
        int[] ans = new int[n+m];
        for (int i : A) {
            ans[k++] = i;
        }
        for (int i : B) {
            ans[k++] = i;
        }

        Arrays.sort(ans);

        k=0;
        for (int i = 0; i < n; i++) {
            A[i] = ans[k++];
        }
        for (int i = 0; i < m; i++) {
            B[i] = ans[k++];
        }

    }


    public static void merge2(int[] A, int B[], int n, int m) {
        // code here
        int i, k;
        for (i = 0; i < n; i++) {
          // take first element from A 
          // compare it with first element of second array
          // if condition match, then swap
          if (A[i] > B[0]) {
            int temp = A[i];
            A[i] = B[0];
            B[0] = temp;
          }
    
          // then sort the second array
          // put the element in its correct position
          // so that next cycle can swap elements correctly
          int first = B[0];
          // insertion sort is used here
          for (k = 1; k < m && B[k] < first; k++) {
            B[k - 1] = B[k];
          }
          B[k - 1] = first;
        }
      }

}



// LEETCODE PROBLM : 88 Merge Two Sorted Array

// public class MergeTwoSortedArray {

//     public static void main(String[] args) {
        
//         int A[] = { 2,4,6};
//         int B[] = { 3,5,8};
//         int i = A.length-1 , j = B.length-1, k = A.length + B.length -1;
//         while(i>=0 && j>=0)
//         {
//             A[k--] = A[i] > B[j] ? A[i--] : B[j--];   
//         }
        
//         while(j>=0)
//         {
//             A[k--] = B[j--];
//         }
//         System.out.println(Arrays.toString(A));
//     }
        
// }
