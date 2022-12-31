
// https://leetcode.com/problems/maximum-population-year/

public class MaximumPopulationYear {
    public static void main(String[] args) {
        
        int arr[][] = {
            {1950,1961},
            {1960,1971},
            {1970,1981},
        };

        System.out.print("Maximum population year : " + maximumPopulation(arr));

    }


    //brute force
    public static int maximumPopulation(int[][] logs) {

        int[] num = new int[101];   //1950-250 =100 yr
        
        //travering the logs[][] array
        for(int i=0; i<logs.length; i++){   
            
            //incrementing the yr from x year to y year
            for(int j=logs[i][0]; j<logs[i][1]; j++){
                
                //incrementing the yr at index
                num[j - 1950]++;
                
            }
        }
    
        int maxValue=0;
        int maxYear=1950;
    
        //checking which yr has maximum count
        for(int i=0; i<101; i++){
            if(num[i]>maxValue){
                maxValue=num[i];
                maxYear = i+1950;
            }
        }
    
        return maxYear;
        //1950-1950   - 0+1
    
    }


    
    /*
     
    
    // optimal solution
    public static int maximumPopulation(int[][] logs) {
        int[] num = new int[101];   //1950-250 =100 yr
        
        //travering the logs[][] array
        for(int i=0; i<logs.length; i++){   
            
            //incrementing the particular Birth year & decrementing the death year
			
			num[logs[i][0]  - 1950]++;
			num[logs[i][1]  - 1950]--;
        }
        
		//calculating the running sum
		for(int i=1; i<101; i++){
            num[i] = num[i] + num[i-1];
		}
		
        int maxValue=0;
        int maxYear=1950;
        
        //checking which yr has maximum count
        for(int i=0; i<101; i++){
            if(num[i]>maxValue){
                maxValue=num[i];
                maxYear = i+1950;
                
            }
        }
        
        return maxYear;
        
    }
    
    */

}
