import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * LeetCode 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {


    /**
     * Given a binary tree, find its minimum depth.
     * Entry point for recursive calls.
     * 
     * Runtime: 6 ms, faster than 53.62% of Java online submissions.
     * Memory Usage: 62.3 MB, less than 62.12% of Java online submissions.
     * 
     * 52 / 52 test cases passed.
     * Status: Accepted
     * Runtime: 6 ms
     * Memory Usage: 62.3 MB
     * 
     * Execution: O(log(n)) or O(n) - Space: O(1)
     */
    static public int minDepth(TreeNode root) {

        // **** sanity check(s) ****
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        // **** initialization ****
        var leftDepth   = Integer.MAX_VALUE;
        var rightDepth  = Integer.MAX_VALUE;

        // **** traverse left - O(log(n)) ****
        if (root.left != null)
            leftDepth = minDepth(root.left, 1);

        // **** traverse right - O(log(n)) ****
        if (root.right != null)
            rightDepth = minDepth(root.right, 1);

        // **** return min depth ****
        // return Math.min(leftDepth, rightDepth);
        return leftDepth >= rightDepth ? rightDepth : leftDepth;
    }


    /**
     * Recursive call.
     * 
     * Execution: O(log(n)) or O(n) - Space: O(1)
     */
    static private int minDepth(TreeNode root, int depth) {

        // **** base case ****
        if (root.left == null && root.right == null)
            return depth + 1;

        // **** initialization ****
        var leftDepth   = Integer.MAX_VALUE;
        var rightDepth  = Integer.MAX_VALUE;

        // **** traverse left - O(log(n)) ***
        if (root.left != null)
            leftDepth = minDepth(root.left, depth + 1);

        // **** traverse right - O(log(n)) ****
        if (root.right != null)
            rightDepth = minDepth(root.right, depth + 1);

        // **** return min depth ****
        // return Math.min(leftDepth, rightDepth);
        return leftDepth >= rightDepth ? rightDepth : leftDepth;
    }


    /**
     * Test scaffold.
     * !!!! NOT PART OF THE SOLUTION !!!!
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        // **** read and populate string[] for binary tree ****
        String[] strArr = br.readLine().trim().split(",");
    
        // ***** close the buffered reader ****
        br.close();
    
        // ????? ????
        System.out.println("main <<<      strArr: " + Arrays.toString(strArr));
    
        // **** generate Integer[] to create and populate binary tree ****
        int len         = strArr.length;
        Integer[] arr   = new Integer[len];
        for (int i = 0; i < len; i++)
            arr[i] = strArr[i].equals("null") ? null : Integer.parseInt(strArr[i]);
    
        // ????? ????
        System.out.println("main <<<         arr: " + Arrays.toString(arr));
    
        // **** create and populate per level the binary tree ****
        BST bt  = new BST();
        bt.root = bt.populate(arr);

        // ???? in-order traversal ????
        System.out.println("main <<<     inOrder: " + bt.inOrder());

        // ???? post-order traversal ????
        System.out.println("main <<<   postOrder: " + bt.postOrder());

        // ???? level-order traversal ????
        System.out.println("main <<<  levelOrder: " + bt.levelOrder());

        // ???? ????
        System.out.println("main <<<    maxDepth: " + bt.maxDepth(bt.root));

        // **** call the function of interest and display result ****
        System.out.println("main <<<    minDepth: " + minDepth(bt.root));
    }

}