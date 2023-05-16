import java.util.*;
class BinarySearchTree {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}

	TreeNode root;
	private int size;
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	public boolean insert(int v) {
		if (this.root == null) {
			this.root = new TreeNode(v);
		} else {
			TreeNode cur = this.root; TreeNode prev = null;
			while (cur != null) {
				if (cur.val == v) { return false; } // key found
				else if (cur.val > v) {prev = cur; cur = cur.left;} // check left sub tree
				else  {prev = cur; cur = cur.right;} // check right sub tree
			}
			// determine relation between parent node and newly added node
			TreeNode newNode = new TreeNode(v);
			if (prev.val > v) { 
				prev.left = newNode ;
			}
			else {
				prev.right = newNode;
			}
		}	
		this.size++;
		return true;
	} 

	public void delete(int v) {
		this.root = this.deleteHelper(v,this.root);
	}


	private TreeNode deleteHelper(int v,TreeNode root) {
		if (root == null) {
			return root;
		} else {
			if (root.val > v) {
				root.left = deleteHelper(v,root.left);
			} else if (root.val < v) {
				root.right = deleteHelper(v,root.right);
			} else {
				if (root.left == null) return root.right;
				if (root.right == null) return root.left;

				// must keep BST in valid state, so we replace root with successor.
				// delete successor recursively after
				int successorVal  = successor(v,root);
				root.val = successorVal;
				root.right = deleteHelper(successorVal,root.right);
			}
			return root;
		}
	}

	private int successor(int v, TreeNode root) {
		TreeNode cur = root.right;
		if (cur == null) return -1;
		while (cur.left != null) cur = cur.left;
		return cur.val;
	}
	// inorder traversal of BST (give sorted order of vals)
	// L Root R

	public int[] inorder() {
		int[] inorder = new int[this.size];
		if (this.size <=0) return inorder;
		Stack<TreeNode> stack = new Stack<>();
		int idx = 0;
		TreeNode cur,tmp;
		cur = this.root; 
		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			tmp = stack.pop();
			inorder[idx] = tmp.val;
			idx++;
			cur = tmp.right;
		}
		// Lazily modify size;
		if (idx < this.size) {
			this.size = idx;
			return Arrays.copyOf(inorder,idx);
		}
		return inorder;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int[] inorderVals = this.inorder();
		sb.append("Inorder BST -> ");
		for (int v: inorderVals) {
			sb.append(v);
			sb.append(' ');
		}
		return sb.toString();
	}
}
