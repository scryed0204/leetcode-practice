package com.liamtang.otherpractice.tree.rbt;

import java.util.LinkedList;
import java.util.Queue;

import com.liamtang.otherpractice.tree.rbt.TreeNode.NodeColor;

public class RedBlackTree {

	private TreeNode root;

	private TreeNode neel;
	
	private int size = 0;

	public RedBlackTree() {
		this.neel = TreeNode.generateNeel();
		this.root = neel;
		this.root.setParent(neel);
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	TreeNode leftmost(TreeNode current) {
		while (current.getLeftchild() != neel) {
			current = current.getLeftchild();
		}
		return current;
	};

	TreeNode rightmost(TreeNode current) {
		while (current.getRightchild() != neel) {
			current = current.getRightchild();
		}
		return current;
	};

	/**
	 * Find Next Node On In-Order Traversal
	 * 
	 * @param current
	 * @return
	 */
	TreeNode inorderSuccessor(TreeNode current) {
		if (current.getRightchild() != neel) {
			return leftmost(current.getRightchild());
		}

		// 利用兩個pointer: successor與current做traversal
		TreeNode successor = current.getParent();
		while (successor != neel && current == successor.getRightchild()) {
			current = successor;
			successor = current.getParent();
		}
		return successor;
	};

	TreeNode inorderPredecessor(TreeNode current) {
		if (current.getLeftchild() != neel) {
			return rightmost(current.getLeftchild());
		}
		// 利用兩個pointer: predecessor與current做traversal
		TreeNode predecessor = current.getParent();

		while (predecessor != neel && current == predecessor.getLeftchild()) {
			current = predecessor;
			predecessor = predecessor.getParent();
		}

		return predecessor;
	};

	void inorder_by_parent(TreeNode root) {
		TreeNode current = leftmost(root);

		while (null != current) {
			visit(current);
			current = inorderSuccessor(current);
		}
	};

	void inorder_by_parent() {
		inorder_by_parent(root);
	};

	public void inorder(TreeNode current) {
		if (neel != current) { // if current != NULL
			inorder(current.getLeftchild()); // L
			visit(current); // V
			inorder(current.getRightchild()); // R
		}
	};

	public void inorder() {
		inorder(root);
	}

	void levelorder() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		TreeNode current;

		while (null != queue.peek()) {
			current = queue.poll();
			visit(current);
			if (neel != current.getLeftchild())
				queue.add(current.getLeftchild());
			if (neel != current.getRightchild())
				queue.add(current.getRightchild());
		}

	};

	void visit(TreeNode node) {
		if (node != neel)
		System.out.print("[" + node.getColor().toString() + "]" + node.getElement() + " ");
	}

	public TreeNode search(int key) {

		TreeNode current = root;

		while (neel != current && current.getKey() != key) {
			if (key > current.getKey())
				current = current.getRightchild();
			else if (key < current.getKey())
				current = current.getLeftchild();
		}

		return current;
	}

//	private TreeNode addRecursive(TreeNode current, int key, String val) {
//		if (current == null) {
//			return new TreeNode(val, key, NodeColor.RED);
//		}
//
//		if (current.getKey() > key) {
//			current.setLeftchild(addRecursive(current.getLeftchild(), key, val));
//		}
//
//		if (current.getKey() < key) {
//			current.setRightchild(addRecursive(current.getRightchild(), key, val));
//		}
//
//		return current;
//	}

	public void add(int key, String val) {
		if (search(key) != neel) {
			System.out.println(String.format("%d is duplicate key, not allowed.", key));
			return;
		}
		TreeNode y = neel;
		TreeNode x = root;
		TreeNode newNode = new TreeNode(val, key, NodeColor.RED);

		// x 自root向下找到neel並指向它, y則最後會指向x的parent
		while (x != neel) {
			y = x;
			if (newNode.getKey() < x.getKey()) {
				x = x.getLeftchild();
			} else {
				x = x.getRightchild();
			}
		}
		
		newNode.setParent(y);

		if (y == neel) {
			this.root = newNode;
		} else if (newNode.getKey() < y.getKey()) {
			y.setLeftchild(newNode);
		} else {
			y.setRightchild(newNode);
		}

		newNode.setLeftchild(neel);
		newNode.setRightchild(neel);
		
		insertFixedUpRBT(newNode);  // 對可能出現紅色與紅色node相連之情形做修正
		
		size++;
	}

	private void insertFixedUpRBT(TreeNode current) {

		// case0: parent是黑色, 就不用進迴圈
		while (current.getParent().getColor() == NodeColor.RED) { // 若parent是紅色即進入迴圈

			// 上半部：parent是grandparent的left child
			if (current.getParent() == current.getParent().getParent().getLeftchild()) {
				TreeNode uncle = current.getParent().getParent().getRightchild();
				// case1: 若uncle是紅色
				if (uncle.getColor() == NodeColor.RED) { 
					current.getParent().setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					current.getParent().getParent().setColor(NodeColor.RED);   //grandparent改成紅色

					current = current.getParent().getParent();  //FIXME ????
				}
				// case2 & 3: uncle是黑色
				else {
					if (current == current.getParent().getRightchild()) {      // case2
						current = current.getParent();
						leftRotation(current);
					}
					 // case3
					current.getParent().setColor(NodeColor.BLACK);  //把parent塗黑
					current.getParent().getParent().setColor(NodeColor.RED); // grandparent塗紅
					rightRotation(current.getParent().getParent());
				}
			}
			// 下半部：parent是grandparent的right child, 與上半部對稱
			else {
				TreeNode uncle = current.getParent().getParent().getLeftchild();
				// case1: 若uncle是紅色
				if (uncle.getColor() == NodeColor.RED) { 
					current.getParent().setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					current.getParent().getParent().setColor(NodeColor.RED);  //grandparent改成紅色
					
					current = current.getParent().getParent(); //FIXME ????
				}
				// case2 & 3: uncle是黑色
				else {
					if (current == current.getParent().getLeftchild()) {      // case2
						current = current.getParent();
						rightRotation(current);
					}
					 // case3
					current.getParent().setColor(NodeColor.BLACK);   //把parent塗黑
					current.getParent().getParent().setColor(NodeColor.RED); // grandparent塗紅
					
					leftRotation(current.getParent().getParent());
				}
			}

		}
		
		root.setColor(NodeColor.BLACK);
	}

	public void deleteByKey(int key) {

		TreeNode deleteNode = search(key);

		if (null == deleteNode) {
			System.out.println(String.format("Key Not Found: %d", key));
			return;
		}

		TreeNode nodeForRelease = null;
		TreeNode childNodeOfReleased = null;

		if (deleteNode.getLeftchild() == neel || deleteNode.getRightchild() == neel) {
			nodeForRelease = deleteNode;
		} else {
			// 將nodeForRelease設成delete_node的Successor或Predecessor(一定會是leaf node或只有一個child)
			nodeForRelease = inorderSuccessor(deleteNode);
		}

		// 經過這組if-else, nodeForRelease調整成至多只有一個child
		// 全部調整成case1或case2來處理

		// 將childNodeOfReleased指向nodeForRelease的child, 可能是有效記憶體, 也有可能是NULL
		if (nodeForRelease.getLeftchild() != neel) {
			childNodeOfReleased = nodeForRelease.getLeftchild();
		} else {
			childNodeOfReleased = nodeForRelease.getRightchild();
		}

		// 在nodeForRelease被刪除之前, 這個步驟把childNodeOfReleased接回BST
		// 即使childNodeOfReleased是NIL也要把childNodeOfReleased的parent指向有效的記憶體位置
        // 因為在FixUp時需要藉由childNodeOfReleased->parent判斷childNodeOfReleased為leftchild或是rightchild
		childNodeOfReleased.setParent(nodeForRelease.getParent());

		// 接著再把要被釋放記憶體的node之"parent"指向新的child
		// 若刪除的是原先的root, 就把x當成新的root
		if (nodeForRelease.getParent() == neel) {
			this.root = childNodeOfReleased;
		} else if (nodeForRelease.getParent().getLeftchild() == nodeForRelease) {
			// 若childNodeOfReleased是其parent的left
			// child，把childNodeOfReleased取代childNodeOfReleased成為其parent的left child
			nodeForRelease.getParent().setLeftchild(childNodeOfReleased);
		} else {
			// 反之，若childNodeOfReleased是其parent的right
			// child，把childNodeOfReleased取代childNodeOfReleased成為其parent的right child
			nodeForRelease.getParent().setRightchild(childNodeOfReleased);
		}

		if (nodeForRelease != deleteNode) {
			deleteNode.setKey(nodeForRelease.getKey());
			deleteNode.setElement(nodeForRelease.getElement());
		}

		if (nodeForRelease.getColor() == NodeColor.BLACK) {
			deleteFixedUpRBT(childNodeOfReleased);			
		}

	}
	
	private void deleteFixedUpRBT(TreeNode current) {
		// Case0:(i) current是紅色的, 直接把它塗黑
		// (ii) current是root, 直接把它塗黑
		while (current != root && current.getColor() == NodeColor.BLACK) {
			// current是leftchild
			if (current == current.getParent().getLeftchild()) {
				TreeNode sibling = current.getParent().getRightchild();
				// Case1: 如果sibling是紅色
				if (sibling.getColor() == NodeColor.RED) {
					sibling.setColor(NodeColor.BLACK); //sibling塗黑
					current.getParent().setColor(NodeColor.RED); //parent塗紅
					leftRotation(current.getParent());
					sibling = current.getParent().getRightchild();
				}
	            // 進入 Case2、3、4: sibling是黑色
	            // Case2: sibling的兩個child都是黑色
				if (sibling.getLeftchild().getColor() == NodeColor.BLACK && sibling.getRightchild().getColor() == NodeColor.BLACK) {
					sibling.setColor(NodeColor.RED);
					current = current.getParent();     // 若current更新到root, 即跳出迴圈
				}
				// Case3 & 4: current只有其中一個child是黑色
				else {
					// case3: sibling的right child是黑的, left child是紅色
					if (sibling.getRightchild().getColor() == NodeColor.BLACK) {
						sibling.getLeftchild().setColor(NodeColor.BLACK);
						sibling.setColor(NodeColor.RED);
						rightRotation(sibling);
						sibling = current.getParent().getRightchild();
					}
	                // 經過Case3後, 一定會變成Case4
	                // Case 4: sibling的right child 是紅色的, left child是黑色
					sibling.setColor(current.getParent().getColor());
					current.getParent().setColor(NodeColor.BLACK);
					sibling.getRightchild().setColor(NodeColor.BLACK);
					leftRotation(current.getParent());
					current = root; // 將current移動到root, 一定跳出迴圈
				}
			}
			// current是rightchild
			else {
				TreeNode sibling = current.getParent().getLeftchild();
				// Case1: 如果sibling是紅色
				if (sibling.getColor() == NodeColor.RED) {
					sibling.setColor(NodeColor.BLACK); //sibling塗黑
					current.getParent().setColor(NodeColor.RED); //parent塗紅
					rightRotation(current.getParent());
					sibling = current.getParent().getLeftchild();
				}
	            // 進入 Case2、3、4: sibling是黑色
	            // Case2: sibling的兩個child都是黑色
				if (sibling.getLeftchild().getColor() == NodeColor.BLACK && sibling.getRightchild().getColor() == NodeColor.BLACK) {
					sibling.setColor(NodeColor.RED);
					current = current.getParent();     // 若current更新到root, 即跳出迴圈
				}
				// Case3 & 4: current只有其中一個child是黑色
				else {
					// case3: sibling的left child是黑的, right child是紅色
					if (sibling.getLeftchild().getColor() == NodeColor.BLACK) {
						sibling.getRightchild().setColor(NodeColor.BLACK);
						sibling.setColor(NodeColor.RED);
						leftRotation(sibling);
						sibling = current.getParent().getLeftchild();
					}
	                // 經過Case3後, 一定會變成Case4
	                // Case 4: sibling的left child 是紅色的, right child是黑色
					sibling.setColor(current.getParent().getColor());
					current.getParent().setColor(NodeColor.BLACK);
					sibling.getLeftchild().setColor(NodeColor.BLACK);
					rightRotation(current.getParent());
					current = root; // 將current移動到root, 一定跳出迴圈
				}
			}
		}
		current.setColor(NodeColor.BLACK);
	}

	/**
	 * Left Rotate the Subtree of parameter node
	 * 
	 * @param node
	 */
	private void leftRotation(TreeNode node) {
		TreeNode y = node.getRightchild(); // 把y指向傳入node的rightchild, 最後y會變成傳入node的parent
		node.setRightchild(y.getLeftchild()); // 將傳入node的rightchild指向y的leftchild
		
		if (y.getLeftchild() != neel) {   // y的leftchild為NIL則忽略
			y.getLeftchild().setParent(node); // 將原先y的leftchild的parent改成x
		}
		
		y.setParent(node.getParent());

		// 用y取代掉原本傳入node的child位子
		if (node.getParent() == neel) {
			root = y;
		} else if (node == node.getParent().getLeftchild()) {
			node.getParent().setLeftchild(y);
		} else {
			node.getParent().setRightchild(y);
		}

		// 最後，將y的leftchild指向傳入node
		y.setLeftchild(node);
		node.setParent(y);
	}

	private void rightRotation(TreeNode node) {
		TreeNode y = node.getLeftchild();
		node.setLeftchild(y.getRightchild());
		
		if (y.getRightchild() != neel) {
			y.getRightchild().setParent(node);
		}
		
		y.setParent(node.getParent());

		if (node.getParent() == neel) {
			root = y;
		} else if (node == node.getParent().getLeftchild()) {
			node.getParent().setLeftchild(y);
		} else {
			node.getParent().setRightchild(y);
		}

		y.setRightchild(node);
		node.setParent(y);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
