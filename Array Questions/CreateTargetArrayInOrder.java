
// https://leetcode.com/problems/create-target-array-in-the-given-order/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTargetArrayInOrder {

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[index.length];
        for(int i=0; i<index.length; i++)
        {
            solve(target,nums[i],index[i]);    
        }
        
        return target;
    }
    
    public static void solve(int[] target, int value, int index){
        for(int i=target.length-1; i>index; i--){
            target[i] = target[i-1];
        }
        target[index] = value;
    }

    
    
    /*
    
    // small changes
    public static int[] createTargetArray(int[] nums, int[] index){
        int[] target = new int[index.length];    
        
        for(int i=0; i<nums.length; i++){
            for(int j=i; j>index[i]; j--){
                target[j] = target[j-1];
            }
            target[index[i]]=nums[i];
        }
        
        return target;
        
    }
    
    */
    


    /*
     
    // method 2 using List
    public static int[] createTargetArray(int[] nums, int[] index) {
        
        int[] target = new int[index.length];    
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++)
        {
            list.add(index[i], nums[i]);
        }
        
        for(int i=0; i<nums.length; i++)
        {
            target[i] = list.get(i);
        }
        
        return target;
        
    }
    
    */


    public static void main(String[] args) {
        
        int nums[] = {0,1,2,3,4};
        int index[] = {0,1,2,2,1};

        System.out.println(Arrays.toString(createTargetArray(nums, index)));

    }
    
}
