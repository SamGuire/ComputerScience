class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(1);
		bst.insert(-100);
		bst.insert(51);
		for (int i = 75; i < 89; i++) bst.insert(i);
		boolean inserted = bst.insert(1); // Should not add
		System.out.printf("Did not insert ? %s\n",!inserted);
		System.out.println(bst);
		bst.insert(10000);
		bst.delete(51);
		bst.delete(1);
		System.out.println(bst);
	}
}

