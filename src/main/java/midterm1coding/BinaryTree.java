package midterm1coding;

public class BinaryTree {
    private TreeNode root;

    private class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;


        TreeNode(int data) {
            this.data = data;
        }
    }

    // CS245-01 question on midterm #1
    /**
     * Return the number of nodes with children (nodes that are not leaves)
     * @param node root of the subtree
     * @return number of nodes with children
     */
    public int numNodesWithChildren(TreeNode node) {
        if (node == null) // if the tree is empty, it has no nodes
            return 0;
        if (node.left == null && node.right == null) // if it's a leaf, do not count it, return a 0
            return 0;

        // Recursively count nodes with children in the left and right subtree,
        // and add 1 to count the "node" itself since it's not a leaf.
        // If node were a leaf, we'd enter the if statement in line 27 and returned 0.
        return 1 + numNodesWithChildren(node.left) + numNodesWithChildren(node.right);

    }

    // CS245-02 question on midterm #1

    /**
     * Return the sum of values at the leaf nodes.
     * @param node root of the subtree
     * @return sum of leaf values
     */
    public int sumOfLeaves(TreeNode node) {
        if (node == null) // if the tree is empty, there are no nodes, no leaves -> sum is 0
            return 0;
        if (node.left == null && node.right == null) // if the node is a leaf, return the value at the node
            return node.data;

        // Recursively compute the sum of leaves in the left and right subtree and sum them up.
        return sumOfLeaves(node.left) + sumOfLeaves(node.right);
    }


    /**
     * Create a sample tree for testing
     */
    public void createTree() {
        // Note: this is not a binary search tree, just a binary tree
        root = new TreeNode(5);
        TreeNode node10 = new TreeNode(10);
        TreeNode node2 = new TreeNode(2);
        TreeNode node35 = new TreeNode(35);
        TreeNode node3 = new TreeNode(3);
        TreeNode node18 = new TreeNode(18);
        TreeNode node29 = new TreeNode(29);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node9 = new TreeNode(9);

        /*
                   5
            2               10
        18     29        35    3
          1            6         5
         9
         */
        root.right =  node10;
        root.left = node2;
        node10.left = node35;
        node10.right = node3;
        node2.left = node18;
        node2.right = node29;
        node35.left = node6;
        node3.right = node5;
        node18.right = node1;
        node1.left = node9;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree();
        System.out.println(tree.numNodesWithChildren(tree.root)); // 7 nodes that have at least one child
        System.out.println(tree.sumOfLeaves(tree.root)); // 49
    }
}

