
// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

public class DetermineMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        
        int matrix[][] = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };

        int target[][] = {
            {1,1,1},
            {0,1,0},
            {0,0,0}
        };

        System.out.print("Matrix can be obtained by rotation : " + findRotation(matrix, target));
    }

    public static boolean check(int[][] mat,int[][] target){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public static int[][] rotate(int[][] mat){
        int n = mat.length;
        //transpose
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        //reverse(swapping)
        int start = 0;
        int end = n-1;
        while(start<=end){
            for(int i=0; i<n; i++){
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
            }
            start++;
            end--;
        }
        
        return mat;
    }
    
    
    public static boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i<4; i++){
            if(check(mat,target)){
                return true;
            }
            rotate(mat);
        }
        return false;
        
    }


}
