
// https://leetcode.com/problems/sort-colors/
// https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/

import java.util.Arrays;

public class Sort012s {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    static int[] sortArray(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        int low = 0, mid = 0, high = arr.length-1, temp;
        while(mid<=high){
            if(arr[mid]==0){
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        return arr;
    }
}
