import java.util.Arrays;

public class NumberOfTimesArrayRotated {
    public static void main(String[] args) {
    
        int[] arr = {7,8,9,1,2,3,4,5,6};
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("No. of Times Sorted Array Rotated is : " + rotatedArray(arr));
        
    }

    public static int rotatedArray(int[] arr)
    {
        int size = arr.length;

        if(size == 1)
        {
            return 0;
        }

        int start = 0;
        int end = size - 1;

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            int prev = (mid + size - 1) % size;
            int next = (mid + 1) % size;

            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next])
            {
                return mid;
            }
            else if(arr[start] <= arr[mid])
            {
                start = mid + 1;
            }
            else if(arr[start] >= arr[mid])
            {
                end = mid - 1;
            }

        }

        return 0;

    }
}
