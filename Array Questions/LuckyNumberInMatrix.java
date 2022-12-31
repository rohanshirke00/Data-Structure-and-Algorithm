
// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix {
    public static void main(String[] args) {
        int arr[][] = {
            {3,7,8},
            {9,11,13},
            {15,16,17}
        };

        System.out.println("Lucky Number in a matrix : " + luckyNumbers(arr));
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> arr = new ArrayList<Integer>();
        
        for(int i=0; i<matrix.length; i++){
            int minIdx = 0;
            int min = matrix[i][0];
            
            for(int j=0; j<matrix[i].length; j++){
                
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                    minIdx = j;
                }
                
            }
            
            boolean isLucky = true;
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][minIdx] < matrix[j][minIdx]){
                    isLucky = false;
                    break;
                }
            }
            if(isLucky){
                arr.add(matrix[i][minIdx]);
            }
            
        }
        
        return arr;
    }
}
