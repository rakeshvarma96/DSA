public class LCABinaryTree
{
    // Root of the Binary Tree 
    TreeNode root;
    static boolean v1 = false, v2 = false;

    // This function returns pointer to LCA of two given 
    // values n1 and n2. 
    // v1 is set as true by this function if n1 is found 
    // v2 is set as true by this function if n2 is found 
    TreeNode findLCAUtil(TreeNode treeNode, int n1, int n2)
    {
        // Base case 
        if (treeNode == null)
            return null;

        //Store result in temp, in case of key match so that we can search for other key also. 
        TreeNode temp=null;

        // If either n1 or n2 matches with root's key, report the presence 
        // by setting v1 or v2 as true and return root (Note that if a key 
        // is ancestor of other, then the ancestor key becomes LCA) 
        if (treeNode.data == n1)
        {
            v1 = true;
            temp = treeNode;
        }
        if (treeNode.data == n2)
        {
            v2 = true;
            temp = treeNode;
        }

        // Look for keys in left and right subtrees 
        TreeNode left_lca = findLCAUtil(treeNode.left, n1, n2);
        TreeNode right_lca = findLCAUtil(treeNode.right, n1, n2);

        if (temp != null)
            return temp;

        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca != null && right_lca != null)
            return treeNode;

        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca;
    }

    // Finds lca of n1 and n2 under the subtree rooted with 'node' 
    TreeNode findLCA(int n1, int n2)
    {
        // Initialize n1 and n2 as not visited 
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above 
        TreeNode lca = findLCAUtil(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree 
        if (v1 && v2)
            return lca;

        // Else return NULL 
        return null;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LCABinaryTree tree = new LCABinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        TreeNode lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

    }
} 
