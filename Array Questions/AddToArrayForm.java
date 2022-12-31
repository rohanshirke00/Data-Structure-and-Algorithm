
// https://leetcode.com/problems/add-to-array-form-of-integer/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AddToArrayForm {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter " + n + " Elements in an array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter an Intger to add : ");
        int k = sc.nextInt();

        System.out.println("New form of Array is : " + addToArrayForm(arr, k) );

    }


    public static List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        int i = n-1;
        List<Integer> list = new ArrayList<>();
        
        while(i>= 0 || k>0){
            if(i>=0){
                list.add((num[i]+k)%10);
                k = (num[i]+k)/10;
                
            }
            else{
                list.add(k%10);
                k = k/10;
            }
            i--;
            
        }
        Collections.reverse(list);
        return list;
    }

}
