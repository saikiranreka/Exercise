package bst;

public class Node {
	int value;
	Node[] children;

	public Node() {
		children = new Node[2];
	}

	public Node(int v) {
		this();
		value = v;
	}

	public void insertElements(int[] elements) {
		this.value=elements[0];
		for (int i = 1; i < elements.length; i++) {
			insertElement(elements[i]);
		}
	}

	private void insertElement(int i) {
		Node lastNode = getLastNode(i);
		if(lastNode.value>i){
			lastNode.children[0]=new Node(i);
		}else{
			lastNode.children[1]=new Node(i);
		}

	}

	private Node getLastNode(int i) {

		if ((value > i && children[0] == null)
				|| (value < i && children[1] == null)) {
			return this;
		} else if (value > i && children[0] != null) {
			return children[0].getLastNode(i);
		} else {
			return children[1].getLastNode(i);
		}
	}
	
}
