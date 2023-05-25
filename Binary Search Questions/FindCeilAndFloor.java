import java.util.Arrays;
import java.util.Scanner;

public class FindCeilAndFloor{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{
            2,4,5,7,8,9,12
        };
        System.out.println("Arrays : " + Arrays.toString(arr));

        System.out.print("Enter a number to find ceil of it : ");
        int number = sc.nextInt();

        System.out.print("Ceil of a particular number is : " + findCeil(arr, number));
        System.out.println();
        System.out.print("Floor of a particular number is : " + findFloor(arr, number));
        sc.close();

    }

    public static int findCeil(int[] arr, int target) {
        
        int s = 0;
        int e = arr.length - 1;
        int res = -1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == target){
                return arr[mid];
            }
            else if(arr[mid] < target){
                s = mid + 1;
            }
            else{
                res = mid;
                e = mid - 1;
            }
        }
        
        if(res == -1){
           if(target < arr[0]){
                return arr[0];
           }
           return -1;
        }

        return arr[res];

    }


    public static int findFloor(int[] arr, int target) {
        
        int s = 0;
        int e = arr.length - 1;
        int res = -1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] == target){
                return arr[mid];
            }
            else if(arr[mid] < target){
                res = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        
        if(res == -1){
           if(target < arr[0]){
                return -1;
           }
           return arr[arr.length-1];
        }

        return arr[res];

    }


}