package CourseWork.Question_4;
// 4.b
public class BrothersBinaryTree {
    static class TreeNode {//store information of node 
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Store node depths and parents
    private int xDepth = -1;
    private int yDepth = -1;
    private TreeNode xParent = null;
    private TreeNode yParent = null;
    // Check if nodes x and y are brothers
    public boolean areBrothers(TreeNode root, int x, int y) { //checking weather node are brothers or not
        findNodes(root, null, 0, x, y);
        // Check if depths and parents meet brother criteria
        return xDepth == yDepth && xParent != yParent;
    }
    // Recursive helper method
    private void findNodes(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) { // if node is empty then function will return
            return;
        }
        // Update info if node x is found
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        } 
        // Update info if node y is found
        else if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        // Recurse left and right subtrees
        findNodes(node.left, node, depth + 1, x, y);
        findNodes(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {
        //binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        // Nodes to check
        int a = 4;
        int b = 3;
        // Check if brother nodes
        BrothersBinaryTree solution = new BrothersBinaryTree();
        boolean result = solution.areBrothers(root, a, b);
        //printing the result
        System.out.println("Nodes " + a + " and " + b + " are brothers: " + result);
    }
}
/*
Key Steps
    Recursively traverse tree to find node x and y
    Track depth and parent of x and y
    Nodes are brothers if:
        x depth equals y depth
        x and y have different parents
 */

