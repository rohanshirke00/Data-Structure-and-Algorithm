

// https://leetcode.com/problems/k-th-symbol-in-grammar/



import java.util.ArrayList;
import java.util.Scanner;

public class KthSymbolGrammar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = sc.nextInt();

        System.out.print("Enter K : ");
        int K = sc.nextInt();

        if(N <= 0 || K <= 0 || ((int)Math.pow(2, N-1)  < K)){
            System.out.print("\nInvalid Input");
            System.exit(0);
        }

        // Print all grammar for N
        generateGrammar(N);

        System.out.print("\nThe K th Symbol in Grammar : " + solve(N, K));

        sc.close();
    }




    public static int solve(int N, int K){

        if(N==1 && K==1){
            return 0;
        }

        int range = (int) Math.pow(2, N-1);
        int mid = range/2;

        if(K <= mid){
            return solve(N-1, K);
        }
        else{
            return solve(N-1, K-mid) ^ 1;
        }
    }




    public static void generateGrammar(int N) {

        ArrayList<ArrayList<Integer>> grammar = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            
            ArrayList<Integer> list = new ArrayList<>();

            if (i==0) {
                list.add(0);
            }
            else{
                int mid = (int)Math.pow(2, i)/2;
                for (int j = 0; j < (int)Math.pow(2, i); j++) {
                    
                    if(j < mid){
                        list.add(grammar.get(i-1).get(j));
                    }
                    else{
                        list.add((grammar.get(i-1).get(j - mid)) ^ 1);
                    }

                }
            } 
            grammar.add(list);
        }

        System.out.println("Grammar for " + N + " : ");

        for (ArrayList<Integer> arrayList : grammar) {
            System.out.println(arrayList);
        }

    }
}
