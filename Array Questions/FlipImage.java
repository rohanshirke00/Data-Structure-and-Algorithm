
// https://leetcode.com/problems/flipping-an-image/

import java.util.Arrays;
import java.util.Scanner;

public class FlipImage {

    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<(n+1)/2; j++){
                int temp = image[i][j]^1;
                image[i][j] = image[i][n-1-j]^1;
                image[i][n-1-j] = temp;
                
            }
        }
        return image;
    }



    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter size of 2D Image n X n : ");
        int n = sc.nextInt();
        
        int arr[][] = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + i + " row : ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int invertedImage[][] = flipAndInvertImage(arr);

        for (int[] row : invertedImage) {
            System.out.println(Arrays.toString(row));
        }
        
    }

}
