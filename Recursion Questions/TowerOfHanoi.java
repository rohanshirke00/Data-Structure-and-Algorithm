

// https://www.geeksforgeeks.org/java-program-for-tower-of-hanoi/


import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the DISKS : ");
        int disks = sc.nextInt();

        System.out.print("Enter source tower : ");
        sc.nextLine(); // remove the hanging character
        String src = sc.nextLine();

        System.out.print("Enter destination tower : ");
        String dest = sc.nextLine();

        System.out.print("Enter helper tower : ");
        String help = sc.nextLine();

        System.out.print("Total steps was required : " +  toh(disks, src, dest, help));
        sc.close();

    }


    public static int toh(int disks, String src, String dest, String help){

        if(disks == 0){
            return 0;
        }

        int count1 = toh(disks-1, src, help, dest);
        System.out.println("Move " + disks + " from " + src + " -> " + dest);
        int count2 = toh(disks-1, help, dest, src);
        
        return count1+count2+1;

    } 

}

