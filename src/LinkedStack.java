import java.util.EmptyStackException;

// This stack must implement OurStack<Type> using a 
// singly linked data structure
// @author Luis Encinas

public class LinkedStack<Type> implements OurStack<Type> {
	private class Node {
		private Type data;
		private Node next;

		public Node(Type element, Node link) {
			data = element;
			next = link;

		}
	}

	private Node first;

	public LinkedStack() {
		first = null;
	}

	/**
	 * Check if stack is empty to help avoid popping an empty stack.
	 * 
	 * @returns true if there are 0 elements on this stack
	 */
	public boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}

	/**
	 * Put element on "top" of this Stack object.
	 * 
	 * @param element to be placed at the top of this stack
	 */
	public void push(Type element) {
		if (first == null) {
			first = new Node(element, null);
		} else {
			first = new Node(element, first);
		}
	}

	/**
	 * Return reference to the element at the top of stack
	 * 
	 * @returns A reference to the top element.
	 * @throws EmptyStackException if the stack is empty.
	 */
	public Type peek() throws EmptyStackException {
		if (first == null) {
			throw new EmptyStackException();
		}
		return first.data;
	}

	/**
	 * Remove element at top and return reference to it
	 * 
	 * @returns reference to the most recently pushed element
	 * @throws EmptyStackException if the stack is empty.
	 */
	public Type pop() throws EmptyStackException {
		if (first == null) {
			throw new EmptyStackException();
		}
		Type element = first.data;
		first = first.next;
		return element;
	}
}
