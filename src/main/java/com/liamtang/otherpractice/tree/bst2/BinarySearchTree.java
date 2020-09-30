package com.liamtang.otherpractice.tree.bst2;

import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	TreeNode leftmost(TreeNode current) {
		while (current.getLeftchild() != null) {
			current = current.getLeftchild();
		}
		return current;
	};

	TreeNode rightmost(TreeNode current) {
		while (current.getRightchild() != null) {
			current = current.getRightchild();
		}
		return current;
	};

	/**
	 * Find Next Node On In-Order Traversal
	 * @param current
	 * @return
	 */
	TreeNode InorderSuccessor(TreeNode current) {
		if (current.getRightchild() != null) {
			return leftmost(current.getRightchild());
		}

		// 利用兩個pointer: successor與current做traversal
		TreeNode successor = current.getParent();
		while (successor != null && current == successor.getRightchild()) {
			current = successor;
			successor = current.getParent();
		}
		return successor;
	};

	TreeNode InorderPredecessor(TreeNode current) {
		if (current.getLeftchild() != null) {
			return rightmost(current.getLeftchild());
		}
		// 利用兩個pointer: predecessor與current做traversal
		TreeNode predecessor = current.getParent();

		while (predecessor != null && current == predecessor.getLeftchild()) {
			current = predecessor;
			predecessor = predecessor.getParent();
		}

		return predecessor;
	};

	void Inorder_by_parent(TreeNode root) {
		TreeNode current = leftmost(root);

		while (null != current) {
			visit(current);
			current = InorderSuccessor(current);
		}
	};

	void Inorder_by_parent() {
		Inorder_by_parent(root);
	};
	
    public void Inorder(TreeNode current) {
        if (null != current) {           // if current != NULL
            Inorder(current.getLeftchild());  // L
            visit(current);   			 // V
            Inorder(current.getRightchild()); // R
        }
    };
    
    public void Inorder() {
    	Inorder(root);
    }

	void Levelorder() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		TreeNode current;

		while (null != queue.peek()) {
			current = queue.poll();
			visit(current);
			if (null != current.getLeftchild())
				queue.add(current.getLeftchild());
			if (null != current.getRightchild())
				queue.add(current.getRightchild());
		}

	};

	void visit(TreeNode node) {
		System.out.print(node.getData() + "(" + node.getKey() + ") ");
	}

	public TreeNode Search(int key) {
		
		TreeNode current = root;
		
		while (null != current && current.getKey() != key) {
			if (key > current.getKey()) current = current.getRightchild();
			if (key < current.getKey()) current = current.getLeftchild();			
		}
		
		return current;
	}

	private TreeNode addRecursive(TreeNode current, int key, String val) {
		if (current == null) {
			return new TreeNode(key, val);
		}

		if (current.getKey() > key) {
			current.setLeftchild(addRecursive(current.getLeftchild(), key, val));
		}

		if (current.getKey() < key) {
			current.setRightchild(addRecursive(current.getRightchild(), key, val));
		}

		return current;
	}

	public void add(int key, String val) {
		root = addRecursive(root, key, val);
	}
	
	public void DeleteBST(int key) {
		
		TreeNode deleteNode = Search(key);
		
		if (null == deleteNode) {
			System.out.println(String.format("Key Not Found: %d", key));
			return;
		}
		
		TreeNode nodeForRelease = null;
		TreeNode childNodeOfReleased = null;
		
		if (deleteNode.getLeftchild() == null || deleteNode.getRightchild() == null) {
			nodeForRelease = deleteNode;
		} else {
			nodeForRelease = InorderSuccessor(deleteNode); // 將nodeForRelease設成delete_node的Successor
		}
		
		// 經過這組if-else, nodeForRelease調整成至多只有一個child
        // 全部調整成case1或case2來處理	
		
		// 將childNodeOfReleased指向nodeForRelease的child, 可能是有效記憶體, 也有可能是NULL
		if (nodeForRelease.getLeftchild() != null) {
			childNodeOfReleased = nodeForRelease.getLeftchild();
		} else {
			childNodeOfReleased = nodeForRelease.getRightchild();
		}
		
		// 在nodeForRelease被刪除之前, 這個步驟把childNodeOfReleased接回BST
		if (null != childNodeOfReleased) {
			childNodeOfReleased.setParent(nodeForRelease.getParent());
		}
		
		// 接著再把要被釋放記憶體的node之"parent"指向新的child
		// 若刪除的是原先的root, 就把x當成新的root 
		if (nodeForRelease.getParent() == null) {
			this.root = childNodeOfReleased;
		} else if (nodeForRelease.getParent().getLeftchild() == nodeForRelease) {
			// 若childNodeOfReleased是其parent的left child，把childNodeOfReleased取代childNodeOfReleased成為其parent的left child
			nodeForRelease.getParent().setLeftchild(childNodeOfReleased);
		} else {
			// 反之，若childNodeOfReleased是其parent的right child，把childNodeOfReleased取代childNodeOfReleased成為其parent的right child
			nodeForRelease.getParent().setRightchild(childNodeOfReleased);
		}
		
		if (nodeForRelease != deleteNode) {
			deleteNode.setKey(nodeForRelease.getKey());
			deleteNode.setData(nodeForRelease.getData());
		}
		
		nodeForRelease = null;
		
	}

}
