
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// https://takeuforward.org/data-structure/stock-buy-and-sell/

import java.util.Arrays;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,3,9,6,2};

        System.out.println("Stocks : " + Arrays.toString(arr));

        System.out.println("Profit : " + buyAndSell(arr)); //brute force
        System.out.println("Profit : " + buyAndSell2(arr)); //optimal
    }


    // brute force T -> O(N^2)
    static int buyAndSell(int[] arr){
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]>arr[i]){
                    max = Math.max(max, arr[j] - arr[i]);
                }
            }
        }
        return max;
    }


    //optimal solution T -> O(N)
    static int buyAndSell2(int[] arr){
        
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            max = Math.max(max, arr[i] - minPrice);
        }
        return max;
    }
}
