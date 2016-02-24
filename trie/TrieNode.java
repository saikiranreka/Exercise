package trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	public TrieNode parent;
	public TrieNode[] children;
	public boolean isLeaf;
	public boolean isWord;
	public char character;

	public TrieNode() {
		children = new TrieNode[26];
		isLeaf = true;
		isWord = false;
	}

	public TrieNode(char c) {
		this();
		this.character = c;
	}

	public void addWord(String s) {
		isLeaf = false;
		s = s.toLowerCase();
		int index = s.charAt(0) - 'a';
		if (this.children[index] == null) {
			children[index] = new TrieNode(s.charAt(0));
			children[index].parent = this;
		}
		if (s.length() > 1) {
			children[index].addWord(s.substring(1));
		} else {
			children[index].isWord = true;
		}
	}

	public List<String> getWords(String prefix) {

		TrieNode last = getLastNode(prefix);
		if (last == null || last.equals(null)) {
			return null;
		}

		return last.getChildWords(last);
	}

	public List<String> getChildWords(TrieNode node) {
		ArrayList<String> words = new ArrayList<String>();
		if (node.isWord) {
			words.add(node.getParentString());
		}
		if (!node.isLeaf) {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null) {
					words.addAll(node.children[i]
							.getChildWords(node.children[i]));
				}
			}
		}
		return words;
	}

	public String getParentString() {
		if (this.parent == null) {
			return "";
		} else {
			return this.parent.getParentString()
					+ new String(new char[] { this.character });
		}
	}

	public TrieNode getLastNode(String prefix) {
		prefix = prefix.toLowerCase();
		TrieNode lastNode = this;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			lastNode = lastNode.children[index];
		}
		return lastNode;
	}

}
