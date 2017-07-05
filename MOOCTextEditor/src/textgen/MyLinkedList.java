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
	    this.head = new LLNode<>(null);
        this.tail = new LLNode<>(null);
	    this.head.next = tail;
	    this.tail.prev = head;
	    this.size = 0;
	}
	
	public MyLinkedList(E newData) {
	    
	    this();
	    if (newData == null)
	        throw new NullPointerException("Not a valid input!");
	    
	    LLNode<E> newNode = new LLNode<>(newData);
	    newNode.next = this.tail;
	    newNode.prev = this.head;
	    this.tail.prev = newNode;
	    this.head.next = newNode;
	    this.size = 1; 
	    
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
	    if (element == null)
	        throw new NullPointerException("Invalid Input!");
	    LLNode<E> newNode = new LLNode<>(element);
	    tail.prev.next = newNode;
	    newNode.prev = tail.prev;
	    newNode.next = tail;
	    tail.prev = newNode;
	    this.size++;
	    return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
	    if (index < 0 || index > (this.size))
	        throw new IndexOutOfBoundsException("Invalid Index!");
	    
	    LLNode<E> cur = this.head;
	    for (int i = 0; i <= index; i++) {
	        cur = cur.next;
	    }
	    
		return cur.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method

	    if (index < 0 || index > (this.size))
            throw new IndexOutOfBoundsException("Invalid Index!");
	    
	    if (element == null)
	        throw new NullPointerException("Invalid Element!");
	    
	          
        LLNode<E> cur = this.head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        
        LLNode<E> newNode = new LLNode<>(element);
        newNode.prev = cur.prev;
        newNode.next = cur;
        cur.prev.next = newNode;
        cur.prev = newNode;
        this.size++;
	
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
	    if (index < 0 || index > (this.size - 1))
            throw new IndexOutOfBoundsException("Invalid Index!");
             
        LLNode<E> cur = this.head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        
        LLNode<E> temp = cur;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
		return temp.data;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
	    if (index < 0 || index > (this.size - 1))
            throw new IndexOutOfBoundsException("Invalid Index!");
        
        if (element == null)
            throw new NullPointerException("Invalid Element!");
        
        LLNode<E> cur = this.head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        
        E data = cur.data;
        cur.data = element;
        
		return data;
	}
	
	public String toString() {
	    
	    LLNode cur = this.head;
	    String elements = "";
	    while(cur.next.data != null) {
	        elements = elements + cur.next.data + " ";
	        cur = cur.next;
	    }
	    
        return elements;
	    
	}
}


class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
