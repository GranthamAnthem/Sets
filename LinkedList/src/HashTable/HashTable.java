
package HashTable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import linkedlist.LinkedListNode;

public class HashTable {

    private final static int TABLE_SIZE = 97;
    public LinkedListNode[] table = new LinkedListNode[TABLE_SIZE]; 
    public int size = 0;
    
    
    public boolean contains(String key) {
        int index = key.hashCode() % TABLE_SIZE;
        LinkedListNode current = table[index];
        
        while (current != null) {
            if (current.data.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
     
    boolean add(String key) { 
        
        int index = key.hashCode() % TABLE_SIZE;
        
        if(table[index] == null) {
            table[index] = new LinkedListNode(key);
            size++;
            return true;
        }
        else {
            LinkedListNode newNode = table[index];

            while (! newNode.data.equals(key)) {
                   newNode = newNode.next;
                   if(newNode.data.equals(key)) {
                       table[index] = new LinkedListNode(key);
                       size++;
                       return true;
                   }
                   else {
                       newNode.next = new LinkedListNode(key);
                   }
            }
        }
        return false;
    }
    
    int size() {
        return size;
    }

    public static void main(String[] args)throws IOException {
        
        HashTable hash = new HashTable();
        
        File inputFile = new File("pride-and-prejudice.txt");
        Scanner scanFile = new Scanner(inputFile);  
        
        String current;
        while(scanFile.hasNext()) {
            current = scanFile.next();
            hash.add(current.replaceAll("[^a-zA-Z]",""));
        }
        
        System.out.println("There are " + hash.size() + " words in the list");
     
    }
    
}
