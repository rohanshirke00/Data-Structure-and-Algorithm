
// https://leetcode.com/problems/reshape-the-matrix/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReShapeTheMatrix {
    public static void main(String[] args) {
        
        int arr[][] = {
            {4,2},
            {9,3},
            {1,6}
        };

        int r = 2;
        int c = 3;

        int ans[][] = matrixReshape(arr, r, c);

        System.out.println("New Matrix :");
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length != r*c){
            return mat;
        }
        int[][] arr = new int [r][c];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                list.add(mat[i][j]);
            }
        }
        
        int k=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = list.get(k);
                k++;
            }
        }
        
        return arr;
    }
}
