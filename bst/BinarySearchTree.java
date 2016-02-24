package bst;

public class BinarySearchTree {
	public static void main(String[] args) {
		Node root = new Node();
		root.insertElements(new int[]{45,54,7,9,24,76,875,455,676,452});
		BTreePrinter.printNode(root);
	}

}
