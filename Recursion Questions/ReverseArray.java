import java.util.Arrays;

public class ReverseArray {

    /*
    * approach 1 using 2 pointer

    public static void reverse(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverse(arr, ++l, --r);
    }

    public static void main(String[] args) {
        
        int[] arr = {2,3,7,4,5,9};
        int l=0;
        int r=arr.length-1;
        reverse(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }

    
    */


    /*
     * approach 2 using a single pointer
     */

    public static void reverse(int[] arr, int i) {
        int n = arr.length;
        if(i>=n/2){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        reverse(arr, ++i);
    }


    public static void main(String[] args) {
        
        int[] arr = {2,3,7,4,5,9};
        reverse(arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
