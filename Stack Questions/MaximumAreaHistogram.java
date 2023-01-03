
// https://leetcode.com/problems/largest-rectangle-in-histogram/
// https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
// https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/0

import java.util.Arrays;
import java.util.Stack;

class MaximumAreaHitogram{
    public static void main(String[] args) {

        long[] hist = {6, 2, 5, 4, 5, 1, 6};
        long n = hist.length;
        
        // self
        System.out.println("MAH : " + MAH(hist, n));

        // gfg
        // System.out.println("MAH : " + MAH1(hist, n));

    }


    public static long MAH(long[] hist, long n) {

        // Nearest smallet to left
        long[] left = new long[(int)n];
        Stack<Integer> st1 = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if(st1.size() == 0){
                left[i] = -1;
            }
            else if(st1.size() > 0 && hist[i] > hist[st1.peek()]){
                left[i] = st1.peek();
            }
            else if(st1.size() > 0 && hist[i] <= hist[st1.peek()]){

                while ((st1.size() > 0) && (hist[i] <= hist[st1.peek()])) {
                    st1.pop();
                }
                if(st1.empty()){
                    left[i] = -1;
                }
                else{
                    left[i] = st1.peek();
                }
            
            }
            st1.push(i);
        }
        System.out.println("LEFT : " + Arrays.toString(left));
        
        
        
        // nearest samllest to right
        long[] right = new long[(int)n];
        Stack<Integer> st2 = new Stack<>();

        for (int i = (int)n - 1; i >= 0; i--) {
            if(st2.size() == 0){
                right[i] = n;
            }
            else if(st2.size() > 0 && hist[i] > hist[st2.peek()]){
                right[i] = st2.peek();
            }
            else if(st2.size() > 0 && hist[i] <= hist[st2.peek()]){
                
                while ((st2.size() > 0) && (hist[i] <= hist[st2.peek()])) {
                    st2.pop();
                }
                if(st2.empty()){
                    right[i] = n;
                }
                else{
                    right[i] = st2.peek();
                }
                
            }
            st2.push(i);
        }
        System.out.println("RIGHT : " + Arrays.toString(right));
        

        // // calculating width
        long[] width =  new long[(int)n];
        for (int i = 0; i < width.length; i++) {    
            width[i] = right[i] - left[i] - 1;
        }
        System.out.println("WIDTH : " + Arrays.toString(width));


        // calulating maximum area for all hist
        long[] area = new long[(int)n];
        long max = 0;
        for (int i = 0; i < area.length; i++) {
            area[i] = width[i] * hist[i];
            max = area[i] > max ? area[i] : max;
        }
        System.out.println("AREA : " + Arrays.toString(area));

        return max;
        
    }



    //gfg solution
    public static long MAH1(long[] hist, long n) {
        Stack<Integer> st=new Stack<>();
        long[] left=new long[(int)n];
        st.push(0);
        left[0]=-1;

        for(int i=1; i<n; i++)
        {
            while(!st.isEmpty() && hist[i]<=hist[st.peek()])

            {
                st.pop();
            }
            if(st.isEmpty())
            {
                left[i]=-1;
            }
            else
            {
                left[i]=st.peek();
            }

            st.push(i);

        }

        Stack<Integer> st1=new Stack<>();
        long[] right=new long[(int)n];
        st1.push((int)n-1);
        right[(int)n-1]=n;

        for(int i=(int)n-2; i>=0; i--)
        {
            while(!st1.isEmpty() && hist[i]<=hist[st1.peek()])
            {
                st1.pop();
            }
            if(st1.isEmpty())
            {
                right[i]=n;
            }
            else
            {
                right[i]=st1.peek();
            }

            st1.push(i);

        }

        long max=0;
        for(int i=0; i<n; i++)
        {
            long width=right[i]-left[i]-1;
            if(max<(width*hist[i]))
            {
                max=width*hist[i];
            }
        }

        return max;
    }


}