
// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Scanner;

public class CountSubArraysOfSumEqualsToK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int N = sc.nextInt();

        System.out.print("Enter Elements : ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the sum of SubArray : ");
        int K = sc.nextInt();

        System.out.println("Number of subarrays of sum " + K + " : " + longestSubArray(K, arr, N));

    }

    private static int longestSubArray(int K, int[] arr, int N) {
        
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < N; i++) 
        {
            sum = sum + arr[i];
            if(map.containsKey(sum-K))
            {
                ans = ans + map.get(sum - K);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ans;
    }


}