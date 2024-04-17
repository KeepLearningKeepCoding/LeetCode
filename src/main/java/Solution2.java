import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!map.containsKey(c)) {
                int curLength = j - i + 1;
                maxLength = Math.max(maxLength, curLength);
            } else {
                int index = map.get(c);
                if (index < i) {
                    int curLength = j - i + 1;
                    maxLength = Math.max(maxLength, curLength);
                } else {
                    i = map.get(c) + 1;
                }
            }
            map.put(c, j);
        }
        return maxLength;
    }
}
