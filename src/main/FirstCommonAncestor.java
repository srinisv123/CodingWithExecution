package main;

import java.util.HashSet;

/**
 * @author  ssingan on 7/15/15.
 */
 class FirstCommonAncestorImpl implements FirstCommonAncestor {

    public Node commonAncestor(Node one, Node two) {
        // Implementation here

        HashSet<Node> pathHash = new HashSet<>();
        Node currentOne =one;

        if(one == null || two==null) {
            return null;
        }

        while(!currentOne.isRoot()) {
            pathHash.add(currentOne);
            currentOne = currentOne.parent;
        }


        pathHash.add(currentOne);

        Node currentTwo=two;
        while(!currentTwo.isRoot()) {
            if (pathHash.contains(currentTwo)) {
                return currentTwo;
            }
            currentTwo = currentTwo.parent;
        }

        if (pathHash.contains(currentTwo)) {
            return currentTwo;
        }

        return null;


    }

}

public interface FirstCommonAncestor {

    /**
     * Given two nodes of a tree,
     * method should return the deepest common ancestor of those nodes.
     *
     *          A
     *         / \
     *        B   C
     *       / \
     *      D   E
     *         / \
     *        G   F
     *
     *  commonAncestor(D, F) = B
     *  commonAncestor(C, G) = A
     *  commonAncestor(E, B) = B
     */
    Node commonAncestor(Node one, Node two);
}

class Node {

    final Node parent;
    final Node left;
    final Node right;


    public Node(Node parent, Node left, Node right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    boolean isRoot() {
        return parent == null;
    }
}

