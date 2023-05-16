import java.util.*;
class Main {
	public static void main(String[] args) {
		Heap minHeap = new Heap(10);
		minHeap.insert(-10);
		minHeap.insert(10);
		minHeap.insert(100);
		minHeap.insert(2);
		System.out.println(minHeap);
		int[] sortedOrder = new int[10];
		for (int i = 0; i < 4; i++) {
		       	sortedOrder[i] = minHeap.extract();
			System.out.println(minHeap);
		}
		System.out.println(Arrays.toString(sortedOrder));
	}
}
