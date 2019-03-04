package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
 

class SolutionForSortedToBST {
    
    public TreeNode build (int[]nums,int low,int high) {
        if (high - low == 0) {
            TreeNode x = new TreeNode(nums[low]);
            return x;
        }
        if (high - low == 1) {
            TreeNode x = new TreeNode(nums[high]);
            x.left = new TreeNode(nums[low]);
            return x;
        }
        int mid = (low + high)/2;
        TreeNode x = new TreeNode(nums[mid]);
        x.left = build(nums, low, mid-1);
        x.right = build(nums, mid+1, high);
        return x;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = build(nums, 0, nums.length-1);
        return root;
    }
}

public class SortedArrayToBST {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            TreeNode ret = new SolutionForSortedToBST().sortedArrayToBST(nums);
            
            String out = treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
}