
// https://www.interviewbit.com/problems/repeat-and-missing-number-array/
// https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/

import java.util.ArrayList;
import java.util.Arrays;

public class FindRepeatingAndMissing{
    public static void main(String[] args) {
        int A[] = {1,2,2,4};
        
        // solution 1
        System.out.println(Arrays.toString(repeatAndMissing1(A)));
        
        
        long A1[] = {1,2,2,4};
        // solution 2 
        System.out.println(repeatAndMissing2(A1));
        
    }


    

/*
 
    Solution 1: Using Count Sort
 
    T = O(N), S = O(N)

    Intuition + Approach: 
    
    Since the numbers are from 1 to N in the array arr[]

    Take a substitute array of size N+1 and initalize it with 0.
    Traverse the given array and increase the value of substitute[arr[i]] by one .
    Then again traverse the substitute array starting from index 1 to N.
    If you find any index value greater than 1 that is repeating element A.

    If you find any index value = 0 then that is the missing element B.
    
    
*/
    public static int[] repeatAndMissing1(int [] A) {
        
        int[] frequency =  new int[A.length + 1];
        int[] B = new int[2];
        for (int i = 0; i < A.length; i++) 
        {
            frequency[A[i]]++;
        }
        for (int i = 1; i < frequency.length; i++) 
        {
            if(frequency[i]>1)
            {
                B[0] = A[i];
            }
            else if(frequency[i] == 0)
            {
                B[1] = i;
            }
        }
        return B;
        
    }







/*
 
    Solution 2: Using Math
 
    T = O(N), S = O(1)

    Intuition + Approach: 

    The idea is to convert the given problem into mathematical equations. 
    Since we have two variables where one is missing and one is repeating,
    can we form two linear equations and then solve for the values of these two variables using the equations?

    Let’s see how.

    Assume the missing number to be X and the repeating one to be Y.

    Now since the numbers are from 1 to N in the array arr[]. Let’s calculate sum of all integers 
    from 1 to N and sum of squares of all integers from 1 to N. 
    These can easily be done using mathematical formulae.

    Therefore,

    Sum of all elements from 1 to N:

    S = N*(N+1)/2 ---- equation 1
    And, Sum of squares of all elements from 1 to N:

    P = N(N+1)(2N+1)/6. ----- equation 2
    Similarly, find the sum of all elements of the array and sum of squares of all elements of the array respectively.

    s1 = Sum of all elements of the array. —– equation 3
    P1 = Sum of squares of all elements of the array. ——– equation 4
    Now, if we subtract the sum of all elements of array from sum of all elements from 1 to N,
    that should give us the value for (X – Y).

    Therefore,

    (X-Y) = s – s1 = s’

    Similarily,

    X^2 – Y^2 = P – P1 = P’

    or, (X + Y)(X – Y) = P’

    or, (X + Y)*s’ = P’

    or, X + Y = P’/s’

    Great,

    we have the two equations we needed:

    (X – Y) = s’

    (X + Y) = P’/s’

    We can use the two equations to solve and find values for X and Y respectively.
    
    
*/
    public static ArrayList<Integer> repeatAndMissing2(long[] A) {
        
        long N = A.length;
        long S = (N* (N+1))/2;
        long P = (N* (N+1) * (2*N+1))/6;

        for (long i = 0; i < A.length; i++) {
            S = S - A[(int)i];
            P = P - (A[(int)i]*A[(int)i]);
        }

        long repeatingNo = 0, missingNo = 0;

        missingNo = (S + P/S) / 2;
        repeatingNo = missingNo - S;

        ArrayList<Integer> list = new ArrayList<>();
        list.add((int)repeatingNo);
        list.add((int)missingNo);

        return list;
    }

}