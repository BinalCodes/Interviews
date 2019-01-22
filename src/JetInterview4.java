import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */
public class JetInterview4 {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));

	}
	public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0, currLen = 0;
        if(s.length() == 0)
            return 0;
        Map<Character, Integer> myMap = new HashMap<>();
        for(int i = 0 ; i<s.length() ; i++){
            if(myMap.containsKey(s.charAt(i))){
                currLen = Math.max(currLen, myMap.get(s.charAt(i)));
            }
            maxLen = Math.max(maxLen,i - currLen+1);
            myMap.put(s.charAt(i), i+1);
        }
        return maxLen;
    }

}
