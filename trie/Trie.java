package trie;

import java.util.List;

public class Trie {

	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.addWord("saikiran");
		//root.addWord("sai");
		List<String> words = root.getWords("sai");
		System.out.println(words);
	}

}
