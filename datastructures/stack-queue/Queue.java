import java.util.*;
class Queue {
        private int MAX_CAPACITY;
        private int[] queue;
        private int back = -1;
	private int front = 0;
        public Queue(int initialCapacity) {
                this.MAX_CAPACITY = initialCapacity;
                this.queue = new int[this.MAX_CAPACITY];
        }   

	public int toIdx(int pos) {
		return pos  % this.MAX_CAPACITY;
	}

        public boolean isEmpty() {
                return (this.back - this.front)+1 <= 0; 
        }   

        public boolean isFull() {
                return this.back-this.front+1 >= this.MAX_CAPACITY;
        }   

        public boolean  enqueue(int val) {
                if (this.isFull()) {
                        return false;
                }   
		this.back++;
                int idx = toIdx(this.back);
                this.queue[idx] = val;
                return true;
        }   

        public int front() { 
                if (this.isEmpty()) {
                        return -1;
                }   
		int idx = toIdx(this.front);
                return this.queue[idx];
        }   

        public boolean dequeue() {
                if (this.isEmpty()) {
                        return false;
                }   
                this.front++;
                return true;
        }   
        public String toString() {
                StringBuilder sb = new StringBuilder();
		sb.append("Queue -> ");
                for (int i = this.front ; i <= this.back; i++) {
                        sb.append(this.queue[toIdx(i)]);
                        sb.append(" ");
                }   
                return sb.toString();
        }   
}

