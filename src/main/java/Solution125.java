public class Solution125 {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            while (i < j && !Character.isLetterOrDigit(c1 = s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(c2 = s.charAt(j))) {
                j--;
            }

            if (i == j) {
                break;
            }

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                if (c1 != c2 && Math.abs(c1 - c2) != 32) {
                    return false;
                }
            } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                if (c1 != c2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
