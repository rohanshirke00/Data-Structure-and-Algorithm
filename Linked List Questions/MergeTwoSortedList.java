
// https://leetcode.com/problems/merge-two-sorted-lists/

import java.util.Scanner;

public class MergeTwoSortedList {

    public static class Node{
        int val;
        Node next;
        
        Node(){

        }

        Node(int val){
            this.val = val;
            this.next = null;
        }

    }

    public static Node mergeTwoLists(Node list1, Node list2) {

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        Node dummy = new Node();
        
        Node tail = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many items do you want to add in linkedlist 1 : ");        
        int l1Size = sc.nextInt();
        
        Node l1 = new Node();
        Node head = null;
        Node tail = null;
        if(l1Size == 0){
            System.out.println("List1 : []");
        }
        else{
            System.out.print("Enter items in list1 : ");
        }
            
        for (int i = 0; i < l1Size; i++) {
            Node node = new Node(sc.nextInt());
            if(i==0){
                head = node;
                tail = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
        }

        l1 = head;

        head = null;
        tail = null;

        System.out.print("Enter how many items do you want to add in linkedlist 2: ");        
        int l2Size = sc.nextInt();
        Node l2 = new Node();
        if(l2Size == 0){
            System.out.println("List2 : []");
        }
        else{
            System.out.print("Enter items in list2 : ");
        }
            
        for (int i = 0; i < l2Size; i++) {
            Node node = new Node(sc.nextInt());
            if(i==0){
                head = node;
                tail = node;
            }
            else{
                tail.next = node; 
                tail = node;
            }
        }

        l2 = head;
        
        Node ansNode = mergeTwoLists(l1, l2);
        
        if(ansNode == null){
            System.out.println("Merged List is : []");
            return;
        }

        System.out.print("List is : ");

        while(ansNode!=null)
        {
            System.out.print(ansNode.val + " ");
            ansNode = ansNode.next;
        }
    
    }
}
