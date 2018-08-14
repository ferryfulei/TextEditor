package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>() ;
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		newNode.next = tail;
		tail.prev = newNode;
		size ++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index > size -1) {
			throw new IndexOutOfBoundsException("Out of bound");
		}
		LLNode<E>  currentNode = null;
		try {
			int i = -1;
			currentNode = head;
			while(i < index) {
				currentNode = currentNode.next;
				i++;
			}
		}catch(IndexOutOfBoundsException e) {
			
		}
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add (int index, E element )
	{
		// TODO: Implement this method
		if(index < 0 || index > size|| element == null) {
			throw new IndexOutOfBoundsException("Out of bound");
		}
		int i = 0; LLNode<E> currentNode= head;
		while(i < index) {
			currentNode = currentNode.next;
			i++;
		}
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = currentNode.next;
		currentNode.next.prev = newNode;
		newNode.prev = currentNode;
		currentNode.next = newNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{	
		if(index < 0 || index > size -1) {
			throw new IndexOutOfBoundsException("Out of bound");
		}
		int i = -1; LLNode<E> currentNode= head;
		try {
			while(i < index) {
				currentNode = currentNode.next;
				i++;
			}
			currentNode.prev.next = currentNode.next;
			currentNode.next.prev = currentNode.prev;
		}catch(IndexOutOfBoundsException e) {
			
		}
		size--;
		return currentNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set (int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size -1||element == null ) {
			throw new IndexOutOfBoundsException("Out of bound");
		}
		int i = -1; LLNode<E> currentNode= head;
		try {
			while(i < index) {
				currentNode = currentNode.next;
				i++;
			}
			currentNode.data = element;
		}catch(IndexOutOfBoundsException e) {
			
		}
		return element;
}
}
 class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}
