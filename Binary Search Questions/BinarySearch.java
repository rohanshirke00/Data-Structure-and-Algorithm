import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args) {
    
        int[] arr = {2,3,6,7,8,10,13};
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
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }

        }

        return -1;

    }

}