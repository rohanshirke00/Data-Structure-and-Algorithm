

// https://www.geeksforgeeks.org/sum-of-natural-numbers-using-recursion/


import java.util.Scanner;

public class SumOfN {

    
    // approach 1
    public static int fn(int i,int sum) {
        if(i < 0){
            return -1;
        }

        if(i < 1){
            return sum;
        }
        return fn(i-1,sum+i);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = sc.nextInt();

        System.out.print("Sum : " + fn(N, 0));
        sc.close();
    }






    /*
    
    // approach 2
    public static int fn(int n) {
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return -1;
        }
        return n + fn(n-1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = sc.nextInt();

        System.out.print("Sum : " + fn(N));
        sc.close();
    }

    */



}

