package crackingTheCodeInterview;

import java.util.Scanner;

class Node {
	char ch;
	Node next;
	
	Node(char ch) {
		this.ch = ch;
		this.next = null;
	}
}

class Solution {
	public Node reverse (Node root) {
		Node prev = null, run = root;
		while (run != null) {
			Node temp = run.next;
			run.next = prev;
			prev = run;
			run = temp;
		}
		return prev;
	}
}

public class reverseCString {
	
	public static void printNode (Node x) {
		while(x != null) {
			System.out.print(x.ch);
			x =x.next;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Node x = null, root = null;
		for (char c:str.toCharArray()) {
			if (x != null) {
				x.next = new Node(c);
				x = x.next;			
			} else {
				root = new Node(c);
				x= root;
			}			
						
		}
		Node res = new Solution().reverse(root);
		printNode(res);
		sc.close();
	}

}
