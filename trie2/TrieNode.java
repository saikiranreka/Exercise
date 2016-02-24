package trie2;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	public TrieNode parent;
	public TrieNode[] children;
	public char character;
	public boolean isLeaf;
	public boolean isWord;

	public TrieNode() {
		children = new TrieNode[26];
		isLeaf = true;
		isWord = false;
	}

	public TrieNode(char c) {
		this();
		character = c;
	}

	public void addWord(String s) {
		isLeaf = false;
		s = s.toLowerCase();
		int index = s.charAt(0) - 'a';
		if (children[index] == null) {
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
		TrieNode lastNode = getLastNode(prefix);
		if (lastNode == null) {
			return null;
		}
		return getChildStrings(lastNode, prefix);
	}

	private List<String> getChildStrings(TrieNode lastNode, String prefix) {
		List<String> words = new ArrayList<String>();
		if (lastNode.isWord) {
			words.add(prefix);
		}
		if (!lastNode.isLeaf) {
			for (int i = 0; i < lastNode.children.length; i++) {
				if (lastNode.children[i] != null) {
					words.addAll(getChildStrings(lastNode.children[i], prefix
							+ new String(new char[] { lastNode.children[i].character })));
				}
			}

		}
		return words;
	}

	private TrieNode getLastNode(String prefix) {
		TrieNode lastNode = this;
		prefix = prefix.toLowerCase();
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			lastNode = lastNode.children[index];
		}
		return lastNode;
	}
}
