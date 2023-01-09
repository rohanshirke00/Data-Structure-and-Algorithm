import java.util.Arrays;
import java.util.Scanner;

public class BSOnReverseArray{
    public static void main(String[] args) {
    
        int[] arr = {18,17,14,12,10,9,7,6,5,3,2,1};
        System.out.println("Array : " + Arrays.toString(arr));

        System.out.print("Enter an element to find its index : ");
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();
        System.out.println("Index is : " + binarySearch(arr,ele));
        
    }

    public static int binarySearch(int[] arr, int ele)
    {

        int start = 0;
        int end = arr.length-1;

        while(start <= end)
        {
            int mid = start + (end-start)/2;

            if(ele == arr[mid])
            {
                return mid;
            }
            else if(ele < arr[mid])
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