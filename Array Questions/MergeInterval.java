
// https://leetcode.com/problems/merge-intervals/
// https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeInterval {
    
/*

    //solution 1

    public static void main(String[] args) {
        int[][] intervals = {
            {1,3},
            {8,10},
            {2,6},
            {9,9},
            {15,18}
        };
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        intervals = merge(intervals);
        for (int[] arr : intervals) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public static int[][] merge(int[][] intervals){

        List<int[]> res = new ArrayList<>();

        if(intervals.length == 0 || intervals == null){
            //basically we are returning the empty list
            return res.toArray(new int[0][]);
        }

        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {

            if(i[0] <= end){
                end = Math.max(end, i[1]);
            }
            else{
                res.add(new int[] {start, end});
                start = i[0];
                end = i[1];
            }
        }

        res.add(new int[] {start, end});
        
        return res.toArray(new int[0][]);
        
    }
    
*/
    
    
    // solution 2

    public static void main(String args[]) {
        ArrayList < List < Integer >> arr = new ArrayList < > ();
        arr.add(Arrays.asList(new Integer[]{1,3}));
        arr.add(Arrays.asList(new Integer[]{2,4}));
        arr.add(Arrays.asList(new Integer[]{2,6}));
        arr.add(Arrays.asList(new Integer[]{8,9}));
        arr.add(Arrays.asList(new Integer[]{8,10}));
        arr.add(Arrays.asList(new Integer[]{9,11}));
        arr.add(Arrays.asList(new Integer[]{15,18}));
        arr.add(Arrays.asList(new Integer[]{16,17}));
        ArrayList < List < Integer >> ans = merge(arr);
        System.out.println("Merged Overlapping Intervals are ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static ArrayList<List<Integer>> merge(ArrayList<List<Integer>> intervals) {
        
        Collections.sort(intervals,(a,b)-> a.get(0) - b.get(1));

        ArrayList<List<Integer>> merged = new ArrayList<>();

        for(int i=0; i<intervals.size(); i++){

            if(merged.isEmpty() || merged.get(merged.size()-1).get(1) < intervals.get(i).get(0) ){
                ArrayList<Integer> v = new ArrayList<>();
                v.add(intervals.get(i).get(0));
                v.add(intervals.get(i).get(1));

                merged.add(v);
            }
            else{
                merged.get(merged.size()-1).set(1, Math.max(merged.get(merged.size()-1).get(1), intervals.get(i).get(1)));
            }

        }

        return merged;
    }

}
