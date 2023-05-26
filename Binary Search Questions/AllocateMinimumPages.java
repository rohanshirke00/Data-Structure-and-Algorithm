import java.util.Scanner;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Books : ");
        int books = sc.nextInt();
        
        System.out.print("Enter the pages in a book : ");
        int [] A = new int[books];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        
        System.out.print("Enter Number of Students : ");
        int K = sc.nextInt();

        System.out.print("Minimum Pages : " + findMinimumPages(A,K));

        sc.close();

    }

    public static int findMinimumPages(int[] A, int K) {
        
        if(K > A.length){
            return -1;
        }
        
        int max = 0;
        int sum = 0;
        
        for(int i : A){
            sum += i;
            max = Math.max(max, i);
        }
        
        int start = max;
        int end = sum;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isPossible(A, mid, K)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            
        }
        
        return ans;

    }

    public static boolean isPossible(int[] A, int pages, int students) {
        
        int std = 1;
        int sum = 0;
        
        for(int i=0; i < A.length; i++){
            sum += A[i];
            if(sum > pages){
                std += 1;
                sum = A[i];
            }
        }
        
        if(std <= students){
            return true;
        }
        
        return false;

    }


}
