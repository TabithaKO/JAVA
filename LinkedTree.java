
/*
 * LinkedTree.java
 *
 * CS 112, Lab 10, Task 3
 */

import java.util.*;

/*
 * LinkedTree - a class that represents a binary tree containing data
 * items with integer keys.  If the nodes are inserted using the
 * insert method, the result will be a binary search tree.
 */
public class LinkedTree {
    // An inner class for the nodes in the tree
    private class Node {
        private int key; // the key field
        private LLList data; // list of data values for this key
        private Node left; // reference to the left child/subtree
        private Node right; // reference to the right child/subtree

        private Node(int key, Object data) {
            this.key = key;
            this.data = new LLList();
            this.data.addItem(data, 0);
            this.left = null;
            this.right = null;
        }
    }

    // the root of the tree as a whole
    private Node root;

    public LinkedTree() {
        root = null;
    }

    /*
     * Prints the keys of the tree in the order given by a preorder traversal.
     * Invokes the recursive preorderPrintTree method to do the work.
     */
    public void preorderPrint() {
        if (root != null) {
            preorderPrintTree(root);
        }
        System.out.println();
    }

    /*
     * Recursively performs a preorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private static void preorderPrintTree(Node root) {
        System.out.print(root.key + " ");
        if (root.left != null) {
            preorderPrintTree(root.left);
        }
        if (root.right != null) {
            preorderPrintTree(root.right);
        }
    }

    /*
     * Prints the keys of the tree in the order given by a postorder traversal.
     * Invokes the recursive postorderPrintTree method to do the work.
     */
    public void postorderPrint() {
        if (root != null) {
            postorderPrintTree(root);
        }
        System.out.println();
    }

    /*
     * Recursively performs a postorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private static void postorderPrintTree(Node root) {
        if (root.left != null) {
            postorderPrintTree(root.left);
        }
        if (root.right != null) {
            postorderPrintTree(root.right);
        }
        System.out.print(root.key + " ");
    }

    /*
     * Prints the keys of the tree in the order given by an inorder traversal.
     * Invokes the recursive inorderPrintTree method to do the work.
     */
    public void inorderPrint() {
        if (root != null) {
            inorderPrintTree(root);
        }
        System.out.println();
    }

    /*
     * Recursively performs an inorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private static void inorderPrintTree(Node root) {
        if (root.left != null) {
            inorderPrintTree(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null) {
            inorderPrintTree(root.right);
        }
    }

    /*
     * Inner class for temporarily associating a node's depth with the node, so that
     * levelOrderPrint can print the levels of the tree on separate lines.
     */
    private class NodePlusDepth {
        private Node node;
        private int depth;

        private NodePlusDepth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /*
     * Prints the keys of the tree in the order given by a level-order traversal.
     */
    public void levelOrderPrint() {
        LLQueue<NodePlusDepth> q = new LLQueue<NodePlusDepth>();

        // Insert the root into the queue if the root is not null.
        if (root != null) {
            q.insert(new NodePlusDepth(root, 0));
        }

        // We continue until the queue is empty. At each step,
        // we remove an element from the queue, print its value,
        // and insert its children (if any) into the queue.
        // We also keep track of the current level, and add a newline
        // whenever we advance to a new level.
        int level = 0;
        while (!q.isEmpty()) {
            NodePlusDepth item = q.remove();

            if (item.depth > level) {
                System.out.println();
                level++;
            }
            System.out.print(item.node.key + " ");

            if (item.node.left != null) {
                q.insert(new NodePlusDepth(item.node.left, item.depth + 1));
            }
            if (item.node.right != null) {
                q.insert(new NodePlusDepth(item.node.right, item.depth + 1));
            }
        }
        System.out.println();
    }

    /*
     * Searches for the specified key in the tree. If it finds it, it returns the
     * list of data items associated with the key. Invokes the recursive searchTree
     * method to perform the actual search.
     */
    public LLList search(int key) {
        Node n = searchTree(root, key);
        if (n == null) {
            return null;
        } else {
            return n.data;
        }
    }

    /*
     * Recursively searches for the specified key in the tree/subtree whose root is
     * specified. Note that the parameter is *not* necessarily the root of the
     * entire tree.
     */
    private static Node searchTree(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key == root.key) {
            return root;
        } else if (key < root.key) {
            return searchTree(root.left, key);
        } else {
            return searchTree(root.right, key);
        }
    }

    /*
     * Inserts the specified (key, data) pair in the tree so that the tree remains a
     * binary search tree.
     */
    public void insert(int key, Object data) {
        // Find the parent of the new node.
        Node parent = null;
        Node trav = root;
        while (trav != null) {
            if (trav.key == key) {
                trav.data.addItem(data, 0);
                return;
            }
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }

        // Insert the new node.
        Node newNode = new Node(key, data);
        if (parent == null) { // the tree was empty
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    /*
     * FOR TESTING: Processes the integer keys in the specified array from left to
     * right, adding a node for each of them to the tree. The data associated with
     * each key is a string based on the key.
     */
    public void insertKeys(int[] keys) {
        for (int i = 0; i < keys.length; i++) {
            insert(keys[i], "data for key " + keys[i]);
        }
    }

    /*
     * Deletes the node containing the (key, data) pair with the specified key from
     * the tree and return the associated data item.
     */
    public LLList delete(int key) {
        // Find the node to be deleted and its parent.
        Node parent = null;
        Node trav = root;
        while (trav != null && trav.key != key) {
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }

        // Delete the node (if any) and return the removed data item.
        if (trav == null) { // no such key
            return null;
        } else {
            LLList removedData = trav.data;
            deleteNode(trav, parent);
            return removedData;
        }
    }

    /*
     * Deletes the node specified by the parameter toDelete. parent specifies the
     * parent of the node to be deleted.
     */
    private void deleteNode(Node toDelete, Node parent) {
        if (toDelete.left != null && toDelete.right != null) {
            // Case 3: toDelete has two children.
            // Find a replacement for the item we're deleting -- as well as
            // the replacement's parent.
            // We use the smallest item in toDelete's right subtree as
            // the replacement.
            Node replaceParent = toDelete;
            Node replace = toDelete.right;
            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }

            // Replace toDelete's key and data with those of the
            // replacement item.
            toDelete.key = replace.key;
            toDelete.data = replace.data;

            // Recursively delete the replacement item's old node.
            // It has at most one child, so we don't have to
            // worry about infinite recursion.
            deleteNode(replace, replaceParent);
        } else {
            // Cases 1 and 2: toDelete has 0 or 1 child
            Node toDeleteChild;
            if (toDelete.left != null) {
                toDeleteChild = toDelete.left;
            } else {
                toDeleteChild = toDelete.right; // null if it has no children
            }

            if (toDelete == root) {
                root = toDeleteChild;
            } else if (toDelete.key < parent.key) {
                parent.left = toDeleteChild;
            } else {
                parent.right = toDeleteChild;
            }
        }
    }

    /*
     * Computes the sum of the keys in the entire tree. Invokes the recursive
     * sumKeysTree method to do the work.
     */
    public int sumKeys() {
        return sumKeysTree(root); // pass in the root of the tree as a whole
    }

    /*
     * Recursively computes the sum of the keys in the tree/subtree whose root is
     * specified. Note that the parameter is *not* necessarily the root of the
     * entire tree.
     */
    public static int sumKeysTree(Node root) {
        /*** LAB 10: IMPLEMENT THIS METHOD ***/
        return 0;
    }

    /*
     * Iteratively computes the sum of the keys along the path from the root to the
     * node containing the specified key (if any). If the specified key is not in
     * the tree, the method returns the sum of the keys along the path used to
     * determine that the key is missing.
     */
    public int sumAlongPath(int key) {
        /*** LAB 10: IMPLEMENT THIS METHOD ***/
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedTree tree = new LinkedTree();
        tree.insert(7, "root node");
        tree.insert(9, "7's right child");
        tree.insert(5, "7's left child");
        tree.insert(2, "5's left child");
        tree.insert(8, "9's left child");
        tree.insert(6, "5's right child");
        tree.insert(4, "2's right child");
        tree.insert(30, "this is the root");
        tree.insert(45, "this is one of 30's children");
        tree.insert(15, "this is another of 30's children");
        System.out.print(" preorder: ");
        tree.preorderPrint();

        System.out.print("postorder: ");
        tree.postorderPrint();

        System.out.print("  inorder: ");
        tree.inorderPrint();

        System.out.print("\nkey to search for: ");
        int key = in.nextInt();
        in.nextLine();
        Object data = tree.search(key);
        if (data != null) {
            System.out.println(key + " = " + data);
        } else {
            System.out.println("no such key in tree");
        }

        System.out.print("\nkey to delete: ");
        key = in.nextInt();
        in.nextLine();
        data = tree.delete(key);
        if (data != null) {
            System.out.println("removed " + data);
        } else {
            System.out.println("no such key in tree");
        }

        System.out.print("\n preorder: ");
        tree.preorderPrint();

        System.out.print("postorder: ");
        tree.postorderPrint();

        System.out.print("  inorder: ");
        tree.inorderPrint();
	System.out.println( tree.search(45) );
    }
}
