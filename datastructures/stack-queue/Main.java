class Main {
	public static void main(String[] args) {
		Queue q = new Queue(5);
		System.out.println(q);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q);
		q.enqueue(4);
		q.enqueue(5);
		boolean added = q.enqueue(6); // should fail;
		System.out.printf("Failed to enqueue to q -> %s\n",!added);
		System.out.println(q);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q);
	}
}
