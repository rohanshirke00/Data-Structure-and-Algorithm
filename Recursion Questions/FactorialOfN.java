

// https://www.geeksforgeeks.org/program-for-factorial-of-a-number/


import java.util.Scanner;

public class FactorialOfN {

    public static int fact(int N) {
        
        if(N<0){
            return -1;
        }
        if(N==0)
            return 1;
        return N * fact(N-1);


        // OR
        // return (N < 0) ? -1 : (N == 0) ? 1 :  N * fact(N-1);
        
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = sc.nextInt();

        System.out.print("Factorial of " + N + " is : " + fact(N));
        sc.close();

    }

}
