package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int start;
    int end;
    int sum;
    Node (int start,int end,int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}
class Solution {
    
    public Node findCross(int[] arr, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE,leftPos =mid,rightPos =mid+1;
        int sum =0;
        for (int i=mid;i>=left;i--) {
            sum += arr[i];
            if (sum > leftSum){
                leftSum = sum;
                leftPos = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum =0;
        for (int j=mid+1;j<=right;j++) {
            sum += arr[j];
            if (sum > rightSum){
                rightSum = sum;
                rightPos = j;
            }
        }
        return new Node (leftPos,rightPos,leftSum+rightSum);
    }
    
    public Node findmaxSub(int[] arr, int left, int right) {      
        if (left == right) {
            Node x = new Node(left,right, arr[left]);
            return x;
        } else {
            int mid = (right + left)/2;    
            Node leftNode = findmaxSub(arr,left,mid);
            Node crossNode = findCross(arr,left,mid,right);
            Node rightNode = findmaxSub(arr,mid+1,right);
            if (leftNode.sum >= crossNode.sum && leftNode.sum >= rightNode.sum) {
                return leftNode;
            } else {
                if (rightNode.sum >= crossNode.sum && rightNode.sum>= leftNode.sum) {
                    return rightNode;
                } else {
                    return crossNode;
                }
            }
            
        }
    }
    
    public int maxSubArray(int[] nums) {
        Node res = findmaxSub(nums,0,nums.length -1);
        return res.sum;
    }
}

public class maximumSubarray {
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().maxSubArray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}