public class Solution5 {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        int maxLength = 1;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = 0;
                } else {
                    if (i + 1 > j - 1) {
                        dp[i][j] = 2;
                    } else {
                        if (dp[i + 1][j - 1] == 0) {
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                }
                int curLength = j - i + 1;
                if (dp[i][j] > 0 && curLength > maxLength) {
                    left = i;
                    right = j;
                    maxLength = curLength;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
