package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexx {

	public static void main(String[] args) {
		String input = "abbbaaabababababababababaojfoijoijdf";
		String patternString = "(?=(baba))";
		Pattern pattern = Pattern.compile(patternString);
		Matcher m = pattern.matcher(input);
		int count = 0;
		while (m.find()) {
			count++;
		}
		System.out.println(count);
	}

}
