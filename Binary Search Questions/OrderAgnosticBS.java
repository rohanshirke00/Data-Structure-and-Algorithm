import java.util.Arrays;
import java.util.Scanner;

public class OrderAgnosticBS{
    public static void main(String[] args) {
    
        int[] arr = {2,3,6,7,8,10,13};
        // int[] arr = {18,17,14,12,10,9,7,6,5,3,2,1};
        
        System.out.println("Array : " + Arrays.toString(arr));

        System.out.print("Enter an element to find its index : ");
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();
        System.out.println("Index is : " + order(arr,ele));
        
    }

    public static int order(int[] arr, int ele){
        
        if(arr.length == 1 && arr[0] == ele){
            return 0;
        }
        else if(arr.length == 1 && arr[0] != ele){
            return -1;
        }
        
        if(arr[0] < arr[1]){
            return binarySearchASC(arr, ele);
        }
        return binarySearchDESC(arr, ele);


    }

    // elements in an array are in ascending order
    public static int binarySearchASC(int[] arr, int ele)
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

    // elements in an array are in descending order
    public static int binarySearchDESC(int[] arr, int ele)
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