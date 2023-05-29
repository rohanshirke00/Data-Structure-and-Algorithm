import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayUsingRecursion {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int size = sc.nextInt();
        
        System.out.print("Enter Elements in Array : ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            list.add(sc.nextInt());
        }

        sort(list);
        System.out.println(list);


        /*
        
        // approach 2
        int[] arr = {1,2,3,4,5,6,7,8};
        sortArray(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        
        */

        sc.close();
    }

    // approach 1
    public static void sort(ArrayList<Integer> list) {

        // base condition
        if(list.size() == 1){
            return;
        }

        // hypothesis
        int temp = list.get(list.size() - 1);
        list.remove(list.size()-1);
        sort(list);
        
        // Induction
        // insert the lastelement in correct position
        insert(list, temp);
    }

    public static void insert(ArrayList<Integer> list, int temp) {
        if(list.size() == 0 || list.get(list.size()-1) <= temp){
            list.add(temp);
            return;
        }
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list, temp);
        list.add(val);
        return;
    }





    // approach 2
    public static void sortArray(int[] arr, int lastIndex) {
        
        if(lastIndex == 0){
            return;
        }

        sortArray(arr, lastIndex - 1);

        int element = arr[lastIndex];
        int i = 0;
        for (i = lastIndex - 1; i >= 0; i--) {
            if(element < arr[i]){
                arr[i+1] = arr[i];
            }
            else{
                break;
            }
        }
        arr[i+1] = element;
    }


}
