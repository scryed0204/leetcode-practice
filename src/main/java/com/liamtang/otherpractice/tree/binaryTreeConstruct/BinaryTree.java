package com.liamtang.otherpractice.tree.binaryTreeConstruct;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	private TreeNode root;
	
	public BinaryTree(String ss) {
		if (null != ss && ss.length() >=1) {
			root = new TreeNode(ss.charAt(0));
			ss = ss.substring(1);
			this.LevelorderConstruct(ss);			
		}
	}
	
	public BinaryTree(TreeNode root) {
		this.root = root;
	}
	
    void Preorder(TreeNode current) {
    	if (null != current) {
    		visit(current);
    		Preorder(current.getLeftChild());
    		Preorder(current.getRightChild());
    	}
	};
	
    void Inorder(TreeNode current) {
        if (null != current) {           // if current != NULL
            Inorder(current.getLeftChild());  // L
            visit(current);   			 // V
            Inorder(current.getRightChild()); // R
        }
    };
    
    void Inorder() {
    	Inorder(root);
    }
    
    void Postorder(TreeNode current) {
        if (null != current) {           // if current != NULL
        	Postorder(current.getLeftChild());  // L               			 
        	Postorder(current.getRightChild()); // R
            visit(current); // V
        }
    };
    
    void Levelorder() {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
    	
    	queue.add(root);
    	TreeNode current;
    	
    	while(null != queue.peek()) {
    		current = queue.poll();
    		visit(current);
    		if (null != current.getLeftChild()) queue.add(current.getLeftChild());
    		if (null != current.getRightChild()) queue.add(current.getRightChild());
    	}
    	
    };

    TreeNode leftmost(TreeNode current) {
        while (current.getLeftChild() != null){
            current = current.getLeftChild();
        }
        return current;
    };
    
    TreeNode rightmost(TreeNode current) {
        while (current.getRightChild() != null){
            current = current.getRightChild();
        }
        return current;
    };

    TreeNode InorderSuccessor(TreeNode current) {
    	if (current.getRightChild() != null) {
    		return leftmost(current.getRightChild());
    	}
    	
    	// 利用兩個pointer: successor與current做traversal
    	TreeNode successor = current.getParent();
    	while (successor != null && current == successor.getRightChild()) {
    		current = successor;
    		successor = current.getParent();
    	}
    	return successor;
    };
    
    TreeNode InorderPredecessor(TreeNode current) {
        if (current.getLeftChild() != null){
            return rightmost(current.getLeftChild());
        }
        // 利用兩個pointer: predecessor與current做traversal
        TreeNode predecessor = current.getParent();

        while (predecessor != null && current == predecessor.getLeftChild()) {
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
    
    void Inorder_Reverse(TreeNode root) {
    	TreeNode current = rightmost(root);
    	
    	while(null != current) {
    		visit(current);
    		current = InorderPredecessor(current);
    	}
    }; 
    
    void Inorder_Reverse() { 
    	Inorder_Reverse(root);
    };
    
    private void visit(TreeNode node) {
		System.out.print(node.getVal() + " ");
    }

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public void LevelorderConstruct(String ss) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		TreeNode current = root;
		
		char[] charArray = ss.toCharArray();
		int i = 0;
		for (char data : charArray) {
			i++;
			if (data >= 65 && data <= 90) {
				TreeNode newNode = new TreeNode(data);
				newNode.setParent(current);
				if (i%2!=0) {
					current.setLeftChild(newNode);					
				} else {
					current.setRightChild(newNode);		
				}
				queue.add(newNode);
			}
			
			if (i%2 == 0) {
				current = queue.poll();				
			}
		}
	}
	
	public void InsertLevelorder(char data) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		TreeNode current;
		while(queue.peek() != null) {
			current = queue.poll();
			
			if (current.getLeftChild() != null) {
				queue.add(current.getLeftChild());
			} else {
				current.setLeftChild(new TreeNode(data));
				break;
			}
			
			if (current.getRightChild() != null) {
				queue.add(current.getRightChild());
			} else {
				current.setRightChild(new TreeNode(data));
				break;
			}
		}		
	}
}
