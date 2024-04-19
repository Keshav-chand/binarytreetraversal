import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Queue;

public class binarytreetraversal{
    static int value;
    static Scanner sc=new Scanner(System.in);
    Deque <Node> queue = new LinkedList<Node>();

    static class Node{
        int key;
        Node left;
        Node right;
    }
    static Node newNode(int data){
        Node temp= new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    Node insertNode(Node root, int key) {
        Node newnode=newNode(key);
        if(root==null){
            root=newnode;
            queue.add(root);
            return root;
        }
        else{
            Node node;
            node=queue.remove();
            System.out.println("parent is"+node.key);
            if(node.left==null){
                node.left=newnode;
                queue.add(node.left);
                queue.addFirst(node);//level by level
                return root;
            }
            else if(node.right==null){
                node.right=newnode;
                queue.add(node.right);
                return root;
            }
        }
        return root;
    }
    public void level(Node root){
        Queue<Node> queue1=new LinkedList<Node>();
        queue1.add(root);
        while(!queue1.isEmpty()){
            Node tempNode = queue1.poll();
            System.out.println(tempNode.key+" "); 
            if(tempNode.left!=null){
                queue1.add(tempNode.left);
            }
            if(tempNode.right!=null){
                queue1.add(tempNode.right);
            }
        }
    }
    
    public static void main(String[] args) {
        binarytreetraversal b= new binarytreetraversal();
        Node root=null;
        String status="a";
        while(!status.equals("s")){
            System.out.println("Enter the value to insert");
            value=sc.nextInt();
            root=b.insertNode(root, value);
            System.out.println("binary tree using traversal order:");
            b.level(root);
            System.out.println("\n Enter s to stop or any other charachter to continue");
            status=sc.next();
        }
        System.out.println("program completed");
    }



}
