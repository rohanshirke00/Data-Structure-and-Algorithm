
// https://leetcode.com/problems/pascals-triangle-ii/

import java.util.*;
import java.util.Scanner;

public class PascalsTriangleII{

  public static ArrayList<Integer> pascalRow(int r) {
    
    int val = 1;
    ArrayList<Integer> row = new ArrayList<>();
    for(int j=0; j<=r; j++){
        row.add((int)val);
        val = val * (r-j) / (j+1);
    }
    return row;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the row number for printing pascal's Triangle : ");
    int n = sc.nextInt();

    ArrayList<Integer> res = pascalRow(n);
    
    System.out.println(res);
  }
}