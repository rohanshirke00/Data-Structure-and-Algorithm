
// https://leetcode.com/problems/pascals-triangle/
// https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println("Enter N size : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n==1){
            System.out.println(1);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, pre = null;
		for (int i = 0; i < n; ++i) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j)
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j - 1) + pre.get(j));
			
            pre = row;
			res.add(row);
		}

        System.out.println("OUTPUT : \n" + res);

    }

}
