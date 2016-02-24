package med;

public class MinimalEditDistance {

	public static void main(String[] args) {
		test1();
		test2();

	}

	private static void test1() {
		levenShteinDistance("kiran", "kiran");

	}

	private static void test2() {
		levenShteinDistance("sai", "ssss");

	}

	private static void levenShteinDistance(String string, String string2) {
		int[][] dp = new int[string.length() + 1][string2.length() + 1];
		for (int i = 0; i <= string.length(); i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= string2.length(); j++) {
			dp[0][j] = j;
		}
		for (int i = 0; i < string.length(); i++) {
			int c1 = string.charAt(i);
			for (int j = 0; j < string2.length(); j++) {
				int c2 = string2.charAt(j);
				if (c1 == c2) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + 1,
							Math.min(dp[i][j + 1] + 1, dp[i][j] + 1));
				}
			}
		}
		System.out.println(dp[string.length()][string2.length()]);
	}

}
