
// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

import java.util.Scanner;

public class MinimumCostToMoveChipsToSamePosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Minimum Cost is : "  + minCostToMoveChips(arr));
    }

    public static int minCostToMoveChips(int[] position) {
        
        int even = 0;
        int odd = 0;
        for(int i : position){
            if(i%2==0) even++;
            else odd++;
        }
        
        if(even==position.length || odd == position.length) return 0;
        
        return even>odd?odd:even;
    }

}
