import java.util.*;
class Heap {
	private int MAX_CAPACITY;
	private int[] heap;
	private int size = 0;
	public Heap(int initCapacity) {
		this.MAX_CAPACITY = initCapacity;
		this.heap = new int[this.MAX_CAPACITY];
		Arrays.fill(this.heap,Integer.MAX_VALUE);
	}

	public int parent(int idx) {
		if (idx <= 0) return 0;
		return (idx-1) /2;
	}
	public int leftChild(int idx) {
		return idx*2 +1 ;
	}

	public int rightChild(int idx) {
		return idx* 2+2;
	}

	private void  bubbleDown(int idx) {
		if (idx >= this.MAX_CAPACITY) return;
		int minIdx = idx; int tmpIdx = idx;
		int leftChildIdx = leftChild(idx);
		int rightChildIdx = rightChild(idx);
		if (leftChildIdx < this.MAX_CAPACITY && this.heap[minIdx] > this.heap[leftChildIdx]){
			minIdx = leftChildIdx;
		}
		if (rightChildIdx < this.MAX_CAPACITY && this.heap[minIdx] > this.heap[rightChildIdx]){
			minIdx = rightChildIdx;
		}
		if (tmpIdx != minIdx) {
			int tmp = this.heap[tmpIdx];
			this.heap[tmpIdx] = this.heap[minIdx];
			this.heap[minIdx] = tmp;
			bubbleDown(minIdx);
		}
	}

	private void bubbleUp(int idx) {
		if (idx <= 0) return;
		int parentIdx = parent(idx);
		if (this.heap[parentIdx] > this.heap[idx]) {
			int tmp = this.heap[parentIdx];
			this.heap[parentIdx] = this.heap[idx];
			this.heap[idx] = tmp;
			bubbleUp(parentIdx);
		}
	}

	public void insert(int v) {
		if (this.size >= this.MAX_CAPACITY) return;
		this.heap[this.size] = v;
		bubbleUp(this.size);
		this.size++;
		return;
	}

	public int extract() {
		if (this.size <= 0) return -1;
		int minVal = this.heap[0];
		this.heap[0] = this.heap[this.size-1];
		this.heap[this.size-1] = Integer.MAX_VALUE;
		this.size--;
		bubbleDown(0);
		return minVal;
	}


	public String toString() {
		StringBuilder sb =  new StringBuilder();
		for (int v: this.heap) {
			if (v ==Integer.MAX_VALUE) { sb.append("# "); }
			else {
				sb.append(v);
				sb.append(" ");
			}
		}
		return sb.toString();
	}


}
