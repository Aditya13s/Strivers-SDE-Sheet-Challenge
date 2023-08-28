/*
 * TC = O(N^2)
 * SC = O(N)
 */
public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		ArrayList<String> result = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		set.addAll(dictionary);
		wordBreakHelper(s, "", set,  result);
		return result;
	}

	public static void wordBreakHelper(String s, String ans, HashSet<String> set, ArrayList<String> result) {
		if(s.length() == 0) {
			result.add(ans);
			return;
		}

		for(int i=0; i<s.length(); i++) {
			String left = s.substring(0, i+1);
			if(set.contains(left)) {
				String right = s.substring(i+1);
				wordBreakHelper(right, ans + left + " ", set, result);
			}
		}
	}
}
