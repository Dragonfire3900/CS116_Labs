package L10;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(P("racecar"));

	}
	
	public static boolean P(String word) {
		if(word.length() <= 1) {
			return true;
		}
		else {
			if(word.charAt(0) == word.charAt(word.length()-1)) {
				if(P(word.substring(1,word.length()-1))) {
					return true;
				}
			} 
			else {
				return false;
			}
		}
		return false;
	}
}
