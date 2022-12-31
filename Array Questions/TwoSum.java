
// https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter Target : ");
        int target = sc.nextInt();

        System.out.print("Two Sum : " + Arrays.toString(twoSum(arr, target)));

    }

    // brute force
    public static int[] twoSum(int[] nums, int target) {
        for (int i =0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(target== nums[i] + nums[j]) return new int[] {i,j};
            }
        }
        return null;
    }


    /*
    
    
    // optimal
    public static int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Map<Integer, Integer> map =new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
            
        }
        return result;
        
    }
    
    */
    
}
