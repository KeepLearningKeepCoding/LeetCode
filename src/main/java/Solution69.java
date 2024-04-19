public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                if (mid - 1 < x / (mid - 1)) {
                    return mid - 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
