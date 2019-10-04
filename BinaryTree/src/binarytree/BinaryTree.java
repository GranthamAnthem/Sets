
package binarytree;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BinaryTree {

    class TreeNode { 
        String data;
        TreeNode left, right;
        
        TreeNode(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    TreeNode root;
    
    BinaryTree () {
        root = null;
    }
    
    boolean add(String data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        
        TreeNode temp = root;
        while(true) {
            if (data.compareTo(temp.data) < 0)
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                }
                else
                    temp = temp.left;
            else if (data.compareTo(temp.data) > 0)
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                }
            else
                    temp = temp.right;
            else if (data.equals(temp.data))
                return false;   
        }
        return true;
    }

    boolean contains(String data) {
        return contains(root, data) == true;   
    }
    
    boolean contains(TreeNode temp, String data) {
        
       if(temp == null) {
            return false;
       }
       if (temp.data.equals(data)) {
            return true;
        } 
       else if (data.compareTo(temp.data) < 0) {
            return (contains(temp.left, data));
        }

        else {
            return (contains(temp.right, data));
        }
    }
    
    int size() {
        return size(root);
    }

   int size(TreeNode temp) {
       
       if (temp == null)
           return 0;
       
       int count = 1;
        if (temp.left != null) {
            count += size(temp.left);
        }
        if (temp.right!= null) {
            count += size(temp.right);
        }
        return count;
    }
   
   
    public static void main(String[] args) throws IOException {
       
        BinaryTree tree = new BinaryTree();
       
        File inputFile = new File("pride-and-prejudice.txt");
        Scanner scanFile = new Scanner(inputFile);  
        
        String current;
        while(scanFile.hasNext()) {
            current = scanFile.next();
            tree.add(current.replaceAll("[^a-zA-Z]",""));
        }
        
        System.out.println("There are " + tree.size() + " words in the list");
        
        File inputShuffle = new File("words-shuffled.txt");
        Scanner scanShuffle = new Scanner(inputShuffle);
        int count = 0;
        String key;
        while(scanShuffle.hasNext()) {
            key = scanShuffle.next();
            if (tree.contains(key) == false) {
                count++;
            }
        }
        System.out.println(count + " words do not exist in the sets");    
    }   
}
