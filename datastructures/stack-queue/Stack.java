import java.util.*;
class Stack {
	private int MAX_CAPACITY;
	private int[] stack;
	private int top = -1;
	public Stack(int initialCapacity) {
		this.MAX_CAPACITY = initialCapacity;
		this.stack = new int[this.MAX_CAPACITY];
	}

	public boolean isEmpty() {
		return this.top <0;
	}

	public boolean isFull() {
		return this.top >= this.MAX_CAPACITY-1;
	}

	public boolean  push(int val) {
		if (this.isFull()) {
			return false;
		} 
		this.top++;
		this.stack[this.top] = val;
		return true;
	}

	public int peek() { 
		if (this.isEmpty()) {
			return -1;
		}
		return this.stack[this.top];
	}

	public boolean pop() {
		if (this.isEmpty()) {
			return false;
		}
		this.top--;
		return true;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stack -> ");
		for (int i = 0 ; i <= this.top; i++) {
			sb.append(this.stack[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
}
