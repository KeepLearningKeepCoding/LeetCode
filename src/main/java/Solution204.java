import java.util.Arrays;

public class Solution204 {
    public int countPrimes(int n) {
        // 0 和 1 不是质数
        if (n == 0 || n == 1) {
            return 0;
        }

        int count = 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, 2, n + 1, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i; j <= n / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return count;
    }
}
