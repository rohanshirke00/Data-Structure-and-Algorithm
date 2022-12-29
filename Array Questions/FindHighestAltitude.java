import java.util.Scanner;

// https://leetcode.com/problems/find-the-highest-altitude/

public class FindHighestAltitude {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter Elements in array : ");
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Highest Altitude is : " + largestAltitude(arr));

    }


    public static int largestAltitude(int[] gain) {


        //method 1

        // int[] ans = new int[gain.length+1];
        // int max=0;
        // for(int i=1; i<ans.length; i++){
        //     ans[i] = ans[i-1] + gain[i-1];
        //     max = ans[i]>max?ans[i]:max;
        // }
        // return max;
        

        //method 2

        int max=0;
        int runSum=0;
        for(int i=0;i<gain.length; i++){
            runSum = runSum + gain[i];
            if(runSum>max) max = runSum;
        }
        
        return max;
    }


}

