
package linkedlist;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class LinkedList {
    
    public LinkedListNode head;
    public int size;

    
    boolean contains(String data) {
        LinkedListNode current = head; 
        
         if(current == null) {
             return false;
         }
         while(current != null) {
            if(current.data.equals(data)) {
                return true;
                }
            current = current.next;
         }
         return false;
     }
    
     boolean add(String newData) {
         
         LinkedListNode newNode = new LinkedListNode(newData);
         if (head == null) {
             head = newNode;
             size++;
             return true;
         }
         
         if(contains(newData) == false) {
             newNode.next = head;
             head = newNode;
             size++;
             return true;
         }
         else
            return false;
    }
    
    int size() {
        return size;
    }

    public static void main(String[] args) throws IOException {
        
        LinkedList list = new LinkedList();
        
        File inputFile = new File("pride-and-prejudice.txt");
        Scanner scanFile = new Scanner(inputFile);  
        
        String current;
        while(scanFile.hasNext()) {
            current = scanFile.next();
            list.add(current.replaceAll("[^a-zA-Z]",""));
        }
        
        System.out.println("There are " + list.size() + " words in the list");
        
        File inputShuffle = new File("words-shuffled.txt");
        Scanner scanShuffle = new Scanner(inputShuffle);
        String key;
        int count = 0;
        while(scanShuffle.hasNext()) {
            key = scanShuffle.next();
            list.contains(key);
            if(list.contains(key) == false) {
                count++;
            }
        }
        System.out.println(count + " words do not exist in the sets");
        
    }
}
