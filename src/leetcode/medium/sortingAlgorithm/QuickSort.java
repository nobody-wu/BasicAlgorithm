package leetcode.medium.sortingAlgorithm;

/**
 * @author qingtong
 * @since 2023-04-26 23:25
 **/
public class QuickSort {

    /**
     * 获取哨兵
     *
     * @param nums
     * @param left
     * @param right
     */
    public static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) j--;
            while (i < j && nums[i] <= nums[right]) i++;
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    public static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int part = partition(nums, left, right);
        sort(nums, left, part - 1);
        sort(nums, part + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 8, 6, 234, 3546, 72, 1};
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
