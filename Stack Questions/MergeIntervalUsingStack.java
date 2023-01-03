import java.util.Arrays;
import java.util.Stack;

public class MergeIntervalUsingStack {
    public static void main(String[] args) {
        int arr[][] = {
            {1,3},
            {5,7},
            {9,12},
            {23,26},
            {18,24},
            {10,14},
            {8,9}
        };
        
        mergeInterval(arr);

    }
    public static void mergeInterval(int arr[][]) {
        
        Pair pairs[] = new Pair[arr.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if(i==0){
                st.push(pairs[i]);
            }
            else{
                Pair top = st.peek();
                if(pairs[i].st > top.et){
                    st.push(pairs[i]);
                }
                else{
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }

        Stack<Pair> res = new Stack<>();
        while(st.size()>0){
            res.push(st.pop());
        }

        System.out.println("MERGE INTERVALS : ");

        while(res.size()>0){
            Pair ele = res.pop();
            System.out.println("[ " + ele.st + ", " + ele.et + " ]");
        }

    }

    public static class Pair implements Comparable<Pair>{

        int st;
        int et;

        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(MergeIntervalUsingStack.Pair other) {
            
            if(this.st != other.st){
                return this.st - other.st;
            }
            else{
                return this.et - other.et;
            }

        }


    }

}
