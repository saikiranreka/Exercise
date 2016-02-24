package trie2;

import java.util.List;

public class Trie {

	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.addWord("saikiran");
		root.addWord("sai");
		root.addWord("sri");
		root.addWord("ram");
		List<String> words = root.getWords("r");
		System.out.println(words);
	}

}
