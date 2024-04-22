import java.util.PriorityQueue;
import java.util.Queue;

public class Solution215 {
    // 超时
    // public int findKthLargest(int[] nums, int k) {
    //     return quickSort(nums, 0, nums.length - 1, k);
    // }
    //
    // private int quickSort(int[] nums, int left, int right, int k) {
    //     int mid = partition(nums, left, right);
    //     if (mid == k - 1) {
    //         return nums[mid];
    //     } else if (mid > k - 1) {
    //         return quickSort(nums, left, right - 1, k);
    //     } else {
    //         return quickSort(nums, left + 1, right, k);
    //     }
    // }
    //
    // private int partition(int[] nums, int left, int right) {
    //     // select base
    //     Random random = new Random();
    //     int i = left + random.nextInt(right - left + 1);
    //     swap(nums, left, i);
    //
    //     int base = nums[left];
    //     while (left < right) {
    //         while (left < right && nums[right] <= base) {
    //             right--;
    //         }
    //         nums[left] = nums[right];
    //         while (left < right && nums[left] >= base) {
    //             left++;
    //         }
    //         nums[right] = nums[left];
    //     }
    //     nums[left] = base;
    //     return left;
    // }
    //
    // private void swap(int[] nums, int i, int j) {
    //     int tmp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = tmp;
    // }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}
