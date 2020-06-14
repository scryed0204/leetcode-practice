package com.liamtang.otherpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyFifoQueue
{
	
	public static final String COMMAND_SIZE = "SIZE";
	public static final String COMMAND_TAKE = "TAKE";
	public static final String COMMAND_OFFER = "OFFER";
	
	private static final int CAPACITY_LIMIT = 10000;
	private static final int COMMAND_LIMIT = 10000;
	
    private int size = 0;
    
    private int capacity = 0;

    /**
     * Pointer to first node.
     */
    private Node first;

    /**
     * Pointer to last node.
     */
    private Node last;

	
	public MyFifoQueue(int capacity) {
		this.capacity = capacity;
		
	}
	
    private void linkLast(String e) {
        Node f = last;
        Node newNode = new Node(f, e, null);
        last = newNode;
        if (f == null)
            first = newNode;
        else
            f.next = newNode;
        size++;
    }
    
    private void unlink(Node f) {
        final Node next = f.next;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
    }
	
    public boolean offer(String e) {
    	if (size < capacity) {
    		try {
				linkLast(e);
				return true; 		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
    	} else {
    		return false;
    	}
    }
    
    public String take() {
        final Node f = first;
        
        if (null == f) {
        	return null;
        } else {
        	unlink(f);
        	return f.item;
        }
    }
	
    private static class Node {
    	String item;
        Node next;
        Node prev;

        Node(Node prev, String element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
	
    public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	public static void main (String[] args) throws java.lang.Exception
    {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String[] sizeAndCapacity = input.split(" ");
        
        if (2 != sizeAndCapacity.length) {
        	throw new RuntimeException("Not valid commands");
        }
        
        int size = 0;
        int capacity = 0;
        
        try {
        	size = Integer.parseInt(sizeAndCapacity[0]);
        	capacity = Integer.parseInt(sizeAndCapacity[1]);
		} catch (NumberFormatException e) {
			throw e;
		}
        
        if ((1 <= size  && size <= MyFifoQueue.COMMAND_LIMIT) && (0 <= capacity && capacity <= MyFifoQueue.CAPACITY_LIMIT)) {
        	
        	MyFifoQueue fifoQueue = new MyFifoQueue(capacity);
        	String[] commandAndParam = null;
        	while ((input = br.readLine()) != null) {
        		if (size > 0) {
        			commandAndParam = input.split(" ");
        			switch (commandAndParam[0]) {
        			case MyFifoQueue.COMMAND_SIZE: System.out.println(fifoQueue.getSize()); break;
        			case MyFifoQueue.COMMAND_OFFER: System.out.println(fifoQueue.offer(commandAndParam[1])); break;
        			case MyFifoQueue.COMMAND_TAKE: 
        				String value = fifoQueue.take();
        				if (null != value) {
        					System.out.println(value);   					
        				}
        				break;
        			}
        			
        		} else {
        			System.out.println(input);
        		}        	
        		size--;
        	}
        }
        

    }
}