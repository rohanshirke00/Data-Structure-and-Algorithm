
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

import java.util.Scanner;

public class ConvertBinToDecUsingLL{

    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }

    }

    // approach 1
    public int getDecimalValue1(Node head) {
        Node temp = head;
        String str = "";
        while(temp != null){
            str += temp.val;
            temp = temp.next;
        }
        int ans = Integer.parseInt(str, 2);
        return ans;
    }

    // approach 2
    public int getDecimalValue2(Node head) {
        Node temp = head;
        int ans = 0;
        while(temp != null){
            ans = ans * 2;
            ans = ans + (temp.val);
            temp = temp.next;
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Binary representation of a number (0's & 1's) : ");
        String binaryNo = sc.nextLine();
        int n = binaryNo.length();
        ConvertBinToDecUsingLL sll = new ConvertBinToDecUsingLL();
        Node head = null;
        Node tail = null;
        int i = 0;
        while(i < n){
            int val = Integer.parseInt((binaryNo.charAt(i) + ""));
            Node new_node = new Node(val);
            if(head == null){
                head = new_node;
                tail = new_node;
            }
            else{
                Node temp = tail;
                temp.next = new_node;
                tail = new_node;
            }
            i++;
        }

        // solution 1
        // System.out.println("Decimal representation of (" + binaryNo + ") is : " + sll.getDecimalValue1(head));

        // solution 2
        System.out.println("Decimal representation of (" + binaryNo + ") is : " + sll.getDecimalValue2(head));
        
    }
}