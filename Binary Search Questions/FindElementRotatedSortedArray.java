
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

import java.util.Arrays;
import java.util.Scanner;

public class FindElementRotatedSortedArray{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {7,8,9,1,2,3,4,5,6};
        System.out.println("Rotated Soeted Array : " + Arrays.toString(arr));
        System.out.print("Enter an element to find its index : ");
        int target = sc.nextInt();

        int minEleIndex = findElementInRotatedSortedArray(arr);
        
        int binarySearchOnLeftPart = binarySearch(arr, 0, minEleIndex - 1, target);

        int binarySearchOnRightPart = binarySearch(arr, minEleIndex, arr.length - 1, target);

        if(binarySearchOnLeftPart != -1)
        {
            System.out.println("Element found and it's index is : " + binarySearchOnLeftPart);
        }
        else if(binarySearchOnRightPart != -1)
        {
            System.out.println("Element found and it's index is : " + binarySearchOnRightPart);
        }
        else
        {
            System.out.println("This Element is not Present...");
        }
        
        sc.close();

    }


    // finding the index of minimum element in Rotated Sorted Array 
    public static int findElementInRotatedSortedArray(int[] arr)
    {
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            int prevEle = arr[(mid + n - 1) % n];
            int nextEle = arr[(mid + 1) % n];

            if(arr[mid] <= prevEle && arr[mid] <= nextEle)
            {
                return mid;
            }
            else if(arr[start] <= arr[mid])
            {
                start = mid + 1;
            }
            else
            {
                end =  mid - 1;
            }

        }

        return 0;

    }



    // finding the actual index of target element in Rotated Sorted Array 
    public static int binarySearch(int[] arr, int start, int end, int target)
    {
        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid - 1;
            }
        }
        return -1;
    }


}