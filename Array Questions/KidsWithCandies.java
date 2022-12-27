
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsWithCandies {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of kids : ");
        int n = sc.nextInt();
        
        int candies[] = new int[n];
        System.out.print("Enter each kid having candies : ");        
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        System.out.print("Enter extra candies : ");
        int extraCandies = sc.nextInt();
        
        System.out.println(kidsWithCandies(candies, extraCandies));

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int n = candies.length;
        List<Boolean> list = new ArrayList<Boolean>(n);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = candies[i]>max?candies[i]:max;
        }
        
        for(int i=0; i<n; i++){
            list.add((candies[i]+extraCandies) >= max);
        }
        return list;
        
    }

    
}
