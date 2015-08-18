import javax.swing.*;
import java.util.LinkedList;

/**
 * @author ssingan on 8/14/15.
 *
 *
 */

 class Node {
    int data;
    Node left;
    Node right;

    public Node() {
        this(0);
    }

    public Node(int val) {
        left=null;
        right=null;
        data =val;
    }


}
public class LeftTree {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printTreeLevelWise(root);

        Node newLeaf = reverse(root);
        printTreeLevelWise(newLeaf);
    }

    public static Node reverse(Node root) {
        if (root.left == null) {
            return root;
        }

        Node newRoot = reverse(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left=null;
        root.right=null;

        return newRoot;
    }



    public static void printTreeLevelWise(Node root) {


        LinkedList<Node> queue = new LinkedList<>();
        int currentLevelCount =0, nextLevelCount = 0, level =1;

        boolean newLevel = true;

        Node current = root;

        while (current!=null) {

            if (newLevel) {
                System.out.print("Level "+(level++)+": ");
                newLevel = false;
            }

            System.out.print(current.data+ " ");

            if (current.left!=null) {
                queue.addLast(current.left);
                nextLevelCount++;
            }

            if (current.right!=null) {
                queue.addLast(current.right);
                nextLevelCount++;
            }

            if (currentLevelCount == 0) {
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                System.out.print("\n");
                newLevel = true;
            }


            current = queue.pollFirst();
            currentLevelCount--;
        }

    }
}
