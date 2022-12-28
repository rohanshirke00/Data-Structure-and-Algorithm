
// https://leetcode.com/problems/count-items-matching-a-rule/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CountItemsMatchingRule{

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int count=0;
        if(ruleKey.equals("type")){
            for(int i=0; i<items.size(); i++){
                if(items.get(i).get(0).equals(ruleValue)){
                    count++;
                }
            }
        }else if(ruleKey.equals("color")){
            for(int i=0; i<items.size(); i++){
                if(items.get(i).get(1).equals(ruleValue)){
                    count++;
                }
            }
        }else{
            for(int i=0; i<items.size(); i++){
                if(items.get(i).get(2).equals(ruleValue)){
                    count++;
                }
            }
        }
        
        return count;
        
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("How size of items : ");
        int n = sc.nextInt();

        sc.nextLine();

        List<List<String>> items = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        
            List<String> list = new ArrayList<>();

            System.out.println("Enter list-item "+ (i+1) + " : ");
            for (int j = 0; j < 3; j++) {
                list.add(sc.nextLine());
            }

            items.add(list);

        }

        System.out.print("Enter RuleKey : ");
        String ruleKey = sc.nextLine();
        
        System.out.print("Enter RuleValue : ");
        String ruleValue = sc.nextLine();
        
        for (List<String> list : items) {
            System.out.println(list);
        }

        System.out.println("Matches : " + countMatches(items, ruleKey, ruleValue));

    }

}