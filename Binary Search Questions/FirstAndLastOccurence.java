import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOccurence{
    public static void main(String[] args) {
    
        int[] arr = {2,3,4,5,6,7,7,7,7,8,9,10};
        System.out.println("Array : " + Arrays.toString(arr));

        System.out.print("Enter an element to find its first and last occurence : ");
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();
        System.out.println("Index is : " + Arrays.toString(binarySearch(arr, ele)));
        
    }

    public static int[] binarySearch(int[] arr, int ele)
    {
        int[] res = {-1, -1};

        res[0] = firstIndex(arr, ele, true);

        if(res[0] != -1){
            res[1] = firstIndex(arr, ele, false);
        }

        return res;
        
    }

    public static int firstIndex(int[] arr, int ele, boolean firstIndex)
    {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            if(ele < arr[mid])
            {
                end = mid - 1;
            }
            else if(ele > arr[mid])
            {
                start = mid + 1;
            }
            else{
                ans = mid;
                if(firstIndex == true){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            
        }
        return ans;   
    }
    
}