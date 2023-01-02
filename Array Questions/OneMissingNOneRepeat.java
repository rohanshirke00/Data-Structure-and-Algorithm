
// https://www.interviewbit.com/problems/repeat-and-missing-number-array/
// https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
// https://youtu.be/XcSr6TIMl7w

import java.util.*;

public class OneMissingNOneRepeat {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter size of array : ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.print("Enter " + n + " Elements : ");
    for(int i = 0 ; i < n; i++){
      arr[i] = sc.nextInt();
    }
    
    missingNduplicate(arr);

  }

  public static void missingNduplicate(int[] A){

    int xor = A[0];

    for (int i = 1; i < A.length; i++) {
        xor ^= A[i];
    }

    for (int i = 1; i <= A.length; i++) {
        xor ^= i;
    }

    int rsb = xor & -xor;

    int x = 0;
    int y = 0;

    for (int val : A) {
        if((val & rsb) == 0){
            x =  x ^ val;
        }
        else{
            y =  y ^ val;
        }
    }

    for (int i=1; i <= A.length; i++) {
        if((i & rsb) == 0){
            x =  x ^ i;
        }
        else{
            y =  y ^ i;
        }
    }

    for (int val : A) {
        if(val == x){
            System.out.println("Missing Number >> " + y);
            System.out.println("Duplicate Number >> " + x);
            break;
        }
        else if(val == y){
            System.out.println("Missing Number >> " + x);
            System.out.println("Duplicate Number >> " + y);
            break;
        }
    }
   
  }

}
