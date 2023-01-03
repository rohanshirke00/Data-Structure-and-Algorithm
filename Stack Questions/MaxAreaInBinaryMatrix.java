
// https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/

import java.util.Stack;

class MaxAreaInBinaryMatrix {

    public static void main(String[] args) {
        int[][] arr =  {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        int n = arr.length;
        int m = arr[0].length;

        int maxAreaInBinaryMatrix = maxArea(arr, n, m);
        System.out.println(maxAreaInBinaryMatrix);

    }


    public static int maxArea(int arr[][], int n, int m) 
    {

        int maxB[]=new int[m];
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {

            for(int j=0;j<m;j++)
            {

                if(arr[i][j]==0)
                {
                    maxB[j]=0;
                }
                else
                {
                    maxB[j]++;
                }

            }

            max=Math.max(getMaxArea(maxB,m),max);

        }

        return max;

    }

    public static int getMaxArea(int hist[],int n) 
    {

        int sr[]=nsr(hist);
        int sl[]=nsl(hist);

        int width[]=new int[hist.length];
        for(int i=0;i<n;i++)
        {
            width[i]=sr[i]-sl[i]-1;
        }

        int area[]=new int[hist.length];
        for(int i=0;i<n;i++)
        {
            area[i]=hist[i]*width[i];
        }

        
        int max=area[0];
        for(int i=1;i<n;i++)
        {
            if(max<area[i])
            {
                max=area[i];
            }

        }

        return max;

    }

    

    public static int[] nsr(int arr[])
    {

        int sr[]=new int[arr.length];

        Stack<Node> stack=new Stack<>();

        for(int i=arr.length-1;i>=0;i--)
        {

            while(stack.size()>0&&stack.peek().first()>=arr[i])
            {
                stack.pop();
            }

            if(stack.size()==0)
            {
                sr[i]=arr.length;
            }
            else
            {
                sr[i]=stack.peek().second();
            }

            stack.push(new Node(arr[i],i));

        }

        return sr;

    }

    public static int[] nsl(int arr[]){

        int sl[]=new int[arr.length];

        Stack<Node> stack=new Stack<>();
    
        for(int i=0;i<arr.length;i++)
        {

            while(stack.size()>0&&stack.peek().first()>=arr[i])
            {
                stack.pop();
            }

            if(stack.size()==0)
            {
                sl[i]=-1;
            }
            else
            {
                sl[i]=stack.peek().second();
            }

            stack.push(new Node(arr[i],i));

        } 

        return sl;

    }

}




class Node{

    private int value;
  
    private int index;
  
    public Node(int value,int index)
    {

    this.value=value;
    this.index=index;

    }


    public int first()
    {

        return this.value;

    }

    public int second()
    {

        return this.index;
  
      }

  }